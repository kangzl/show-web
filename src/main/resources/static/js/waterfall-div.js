/**
 * Created by kingfish on 2017/7/17.
 */
var $grid = undefined;
var containerSelecter = '.show-container';
var layer = undefined;
(function ($) {
    var page = 1,
        isLoading = false,
        apiURL = 'api/get-shows-div.htm',
        container = containerSelecter,
        $loaderCircle = $('#loaderCircle'),
        $body = $('body'),
        colW = 225,
        columnNum,
        gutter = 20,
        options = {
            itemSelector: '.show',
            columnWidth: '.grid-sizer',
            gutter: gutter,
            isAnimated: true,
            transitionDuration: '0.5s',
            isFitWidth: true
        };

    $loaderCircle.hide();

    function resetContainerWidth(event) {
        /*
        if (colW == undefined) {
            do {
                colW = $('.show:first').width();//动态获取宽度
            }
            while ($('.show:first').length == 0)
            alert(colW);
        }*/
        // check if columns has changed
        var currentColumns = Math.floor(( $body.width()) / colW) - 1;
        if (currentColumns == 0)
            currentColumns = 1;
        if (currentColumns !== columnNum) {
            // set new column count
            columnNum = currentColumns;
            // apply width to container manually, then trigger relayout
            var marginSize = (columnNum - 1) * gutter;
            $(container).width(columnNum * colW + marginSize);
            if ($grid != undefined) {
                $grid.masonry('layout');
            }
        }
    };

    /**
     * When scrolled all the way to the bottom, add more tiles.
     */
    function onScroll(event) {
        // Only check when we're not still waiting for data.
        if (!isLoading) {
            // Check if we're within 100 pixels of the bottom edge of the broser window.
            var closeToBottom = ($(window).scrollTop() + $(window).height() > $(document).height() - 100);
            if (closeToBottom) {
                loadData();
            }
        }
    };

    /**
     * Loads data from the API.
     */
    function loadData() {
        if (page != 1) {
            $loaderCircle.show();
        }
        $.ajax({
            url: apiURL,
            dataType: 'html',
            data: {page: page}, // Page parameter to make sure we load new data
            success: onLoadData
        });
    };

    /**
     * Receives data from the API, creates HTML for images and updates the layout
     */
    function onLoadData(html) {
        isLoading = true;
        $loaderCircle.hide();
        // Increment page index for future calls.
        page++;
        // Create HTML for the images.
        if ($grid == undefined) {
            $(container).append(html);
            imagesLoaded(container, function () {
                $grid = $(container).masonry(options)
            });
        } else {
            // wrap content in jQuery object
            var $content = $(html);
            // add jQuery object
            $grid.append($content).masonry('appended', $content);
            $grid.imagesLoaded().done(function () {
                $grid.masonry('layout');
            });
        }

        $('.show-content').each(function () {
            $(this).collapser({
                mode: 'chars',
                truncate: 50,
                dynamic: true,
                showText: '<button data-loading-text="loading..." class="btn btn-info showmore">展开全部</button>',
                lockHide: true,
                afterShow: function () {
                    $grid.masonry('layout');
                }
            });
        });

        isLoading = false;
    };
    // Capture scroll event.
    $(document).bind('scroll', onScroll);

    $(window).on("debouncedresize", resetContainerWidth);// trigger resize to set container width
    // Load first data from the API.
    loadData();
    //rest Container Width
    resetContainerWidth();

    //esc 关闭弹出层
    $(window).keyup(function (e) {
        if (layer != undefined) {
            if (e.keyCode == 27) {
                layer.closeAll();
            }
        }
    });

})(jQuery);


function doFavorite(o, showId) {
    //alert('收藏成功! id:' + showId);
    //设置class
    var i = $(o).find('i:first');
    if (i.hasClass("fa-star-o")) {
        //do
        i.removeClass("fa-star-o");
        i.addClass("fa-star");
        i.css("color", "red");
    } else {
        //cancel
        i.removeClass("fa-star");
        i.addClass("fa-star-o");
    }
}

function doLike(o, showId) {
    //alert('点赞成功! id:' + showId);
    //设置class
    var i = $(o).find('i:first');
    if (i.hasClass("fa-heart-o")) {
        //do
        i.removeClass("fa-heart-o");
        i.addClass("fa-heart");
        i.css("color", "red");
    } else {
        //cancel
        i.removeClass("fa-heart");
        i.addClass("fa-heart-o");
    }
}

function showDetail(showId) {
    renderDetail(showId)
}

function renderDetail(showId) {
    //alert("detail:" + showId);
    var width = $(containerSelecter).width(), indexFirst, indexSecond, thirdSecond;
    layui.use('layer', function () {
        layer = layui.layer;
        indexFirst = layer.open({
            type: 1,
            scrollbar: false,
            shadeClose: true,
            closeBtn: 0,
            title: false,
            shade: 0.6,
            success: function (layero, index) {
                $("body").css("overflow", "hidden");
                //console.log(layero, index);
                layui.use('layer', function () {
                    var topOffset = 50;
                    var height = $(document.body).height() - topOffset;
                    indexSecond = layer.open({
                        type: 2,
                        shadeClose: true,
                        closeBtn: 0,
                        area: ['65%', height + 'px'],
                        offset: [topOffset + 'px', '8%'],
                        title: false,
                        anim: 0,
                        isOutAnim: false,
                        shade: 0,
                        content: 'api/get-show-detail.htm?showId=' + showId
                    });
                    //layer.iframeAuto(indexSecond);
                });
                layui.use('layer', function () {
                    thirdSecond = layer.open({
                        type: 1,
                        shadeClose: true,
                        closeBtn: 0,
                        area: ['17%', '20%'],
                        offset: ['50px', '75%'],
                        title: false,
                        anim: 0,
                        isOutAnim: false,
                        shade: 0,
                        content: 'user skskkskskskskk'
                    });
                });
            }, end: function () {
                layer.closeAll();
                $("body").css("overflow", "auto");
            }
        });
    });
}
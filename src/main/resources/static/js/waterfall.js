/**
 * Created by kingfish on 2017/7/17.
 */
var $grid = undefined;
(function ($) {
    var page = 1,
        isLoading = false,
        apiURL = 'api/get-shows.json',
        container = '#container',
        $loaderCircle = $('#loaderCircle'),
        options = {
            itemSelector: '.show',
            columnWidth: '.grid-sizer',
            gutter: 20,
            isAnimated: true,
            transitionDuration: '0.5s'
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
        $loaderCircle.show();
        $.ajax({
            url: apiURL,
            dataType: 'json',
            data: {page: page}, // Page parameter to make sure we load new data
            success: onLoadData
        });
    };
    /**
     * Receives data from the API, creates HTML for images and updates the layout
     */
    function onLoadData(result) {
        isLoading = true;
        var data = result.data;
        $loaderCircle.hide();
        // Increment page index for future calls.
        page++;
        // Create HTML for the images.
        var html = '';
        var i = 0, length = data.length, show;
        for (; i < length; i++) {
            show = data[i];
            html += '<li class="show grid-sizer">';
            html += '<div class="show-menu"><a href="https://baidu.com"><span>添加</span></a>|<a href="http://csdn.com"><span>删除</span></a></div>';
            // Image tag (preview in Wookmark are 200px wide, so we calculate the height based on that).
            html += '<img class="show-img" src="' + show.preview + '">';
            // Image title.
            var interactInfo = '<div class="interact-info"><div class="interact-data"><i class="fa fa-heart" style="color: red"/> 533 <i class="fa fa-comments" style="color: mediumseagreen"/> 123</div><div class="interact-users"><img class="img-circle" src="//ae01.alicdn.com/kf/UTB8EgHRbGrFXKJk43Ovq6ybnpXaV.jpg_50x50.jpg" alt="头像"/><img class="img-circle" src="//ae01.alicdn.com/kf/UTB8EgHRbGrFXKJk43Ovq6ybnpXaV.jpg_50x50.jpg" alt="头像"/><img class="img-circle" src="//ae01.alicdn.com/kf/UTB8EgHRbGrFXKJk43Ovq6ybnpXaV.jpg_50x50.jpg" alt="头像"/></div></div>';
            var showContent = '<div class="show-info"><div class="user-info"><i class="fa fa-certificate" style="color: lightblue"/></div><div class="show-content">' + show.title + '</div></div>';
            html += interactInfo + showContent;
            html += '</li>';
        }
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
        isLoading = false;
    };
    // Capture scroll event.
    $(document).bind('scroll', onScroll);
    // Load first data from the API.
    loadData();
})(jQuery);
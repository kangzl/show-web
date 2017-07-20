/**
 * Created by kingfish on 2017/7/17.
 */
var $grid = undefined;
(function ($) {
    var page = 1,
        isLoading = false,
        apiURL = 'api/get-shows-div.htm',
        container = '.show-container',
        $loaderCircle = $('#loaderCircle'),
        options = {
            itemSelector: '.show',
            columnWidth: '.grid-sizer',
            gutter: 20,
            isAnimated: true,
            transitionDuration: '0.5s',
            isFitWidth:true,
            resize:true
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
    // Load first data from the API.
    loadData();
})(jQuery);
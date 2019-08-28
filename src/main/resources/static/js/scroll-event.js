//文档高度
function getDocumentTop() {
    var scrollTop = 0,
        bodyScrollTop = 0,
        documentScrollTop = 0;
    if (document.body) {
        bodyScrollTop = document.body.scrollTop;
    }
    if (document.documentElement) {
        documentScrollTop = document.documentElement.scrollTop;
    }
    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
    return scrollTop;
}

//可视窗口高度
function getWindowHeight() {
    var windowHeight = 0;
    if (document.compatMode == "CSS1Compat") {
        windowHeight = document.documentElement.clientHeight;
    } else {
        windowHeight = document.body.clientHeight;
    }
    return windowHeight;
}

//滚动条滚动高度
function getScrollHeight() {
    var scrollHeight = 0,
        bodyScrollHeight = 0,
        documentScrollHeight = 0;
    if (document.body) {
        bodyScrollHeight = document.body.scrollHeight;
    }

    if (document.documentElement) {
        documentScrollHeight = document.documentElement.scrollHeight;
    }
    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
    return scrollHeight;
}


/*
当滚动条滑动，触发事件，判断是否到达最底部
然后调用ajax处理函数异步加载数据
*/
window.onscroll = function() {
    console.log(getScrollHeight() + ',' + getWindowHeight() + getDocumentTop());
    //监听事件内容
    if (getScrollHeight() <= getWindowHeight() + getDocumentTop()) {
        //当滚动条到底时,这里是触发内容
        //异步请求数据,局部刷新dom
        console.log('wow');
        loadRecommQues();
    }
}
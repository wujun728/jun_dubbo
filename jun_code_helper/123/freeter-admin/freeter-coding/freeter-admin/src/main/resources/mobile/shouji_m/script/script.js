jQuery(".txtMarquee-left").slide({mainCell:".bd ul",autoPlay:true,effect:"leftMarquee",vis:2,interTime:50});

// 轮播
var mySwiper = new Swiper('.swiper-container', {
    autoplay: 5000,//可选选项，自动滑动
    loop : true,
    pagination : '.swiper-pagination',
    paginationClickable :true,
})
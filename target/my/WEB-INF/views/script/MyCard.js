// 通过这种算法，在设备下1rem = 100px
        changeRootFont();
        function changeRootFont() {            
            document.documentElement.style.fontSize =
                    ((window.innerWidth / 750) * 100) + 'px';
        }           
        window.addEventListener('resize', changeRootFont, false);

//获取openId
var addr=window.location.search;
var openid =addr.split("=")[1];

//进入我的会员卡页面就要发起ajax请求获取数据
$.ajax({
	type:'GET',
	url:"http://weixin.ppplans.com/vipcard/qrCodeController?jsonCallBack=callback&openId="+openid,
	dataType:"jsonp",
	jsonpCallback:"callback",
	success:function(data){
		$(".myphoto-div").attr("src",data.user.userPhoto);
		$(".i-name-span").append(data.user.userName);
		$(".i-sp-s").append(data.user.userSchool);
		$(".i-sp-p").append(data.user.phone);
		$(".i-sp-c").append(data.cardId);
	},
	error:function(){
		alert("获取数据失败！");
	}
})

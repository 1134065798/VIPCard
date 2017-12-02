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

//进入我的会员信息页面就要发起ajax请求
		$.ajax({
			type:"GET",
			url:"http://weixin.ppplans.com/vipcard/usersController?jsonCallBack=callback&openId="+openid,
//			url:"http://localhost:8080/usersController?jsonCallBack=callback&openId="+openid,
			dataType:"jsonp",
			jsonpCallback:"callback",
			success:function(data){
			 		$(".i-name-span").append(data.user.userName);
			 		$(".i-sp-s").append(data.user.userSchool);
			 		$(".i-sp-p").append(data.user.phone);
			 		$(".d-active-d").append(data.vipCard.createTime);
			 		$(".d-photo-div").attr("src",data.user.userPhoto);
			 		$(".d-twocode-div").attr("src",data.vipCard.qrCode);
			},
			error:function(){
				alert("获取数据失败！");
			}
		})

// 通过这种算法，在设备下1rem = 100px
            changeRootFont();
            function changeRootFont() {            
                document.documentElement.style.fontSize =
                        ((window.innerWidth / 750) * 100) + 'px';
            }           
            window.addEventListener('resize', changeRootFont, false);

//获取验证码倒计时
var oGetcode=document.getElementById('getCode');
  oGetcode.onclick=function(){
        var timer=null;
        var i=59;
        oGetcode.disabled=true;
        timer=setInterval(function(){
                    if(i>0){
                    	oGetcode.value=i--+'s后重新发送';
                    }else{
                       clearInterval(timer);
                       oGetcode.disabled=false;
                       oGetcode.value='获取验证码';
                    }
            
            },1000);
        }
//输入框的判断
var oName=document.getElementById('name');
var oSchool=document.getElementById('school');
var oMajor=document.getElementById('major');
var oPhone=document.getElementById('phone');
var oImg=document.getElementById('btn1-img');
var oBtn1photo=document.getElementById('btn1-photo');
var oBtn1=document.getElementById('btn1-input');
var oBtn2=document.getElementById('btn2');
var oVerinput=document.getElementById('ver-input');
var oNainput=document.getElementById('number-active-input');
function isChinese(){
    if(this.value==''){
        this.placeholder='内容不能为空';
    }else{
        if(this.id=="phone"){
            var rephone=/^1[3|4|5|8][0-9]\d{8}$/;
            var resultphone=rephone.test(this.value);
            if(!resultphone){
                this.value='';
                this.placeholder='请填写正确的11位手机号';
            }
        }
        if(this.id=="name" || this.id=="school" || this.id=="major"){
            var re=/^[\u4E00-\u9FFF]+$/;
            var result=re.test(this.value);
            if(!result){
                this.value='';
                this.placeholder='内容只能为汉字';
            }
        }
    }
}
oName.onblur=isChinese;
oSchool.onblur=isChinese;
oMajor.onblur=isChinese;
oPhone.onblur=isChinese;
oVerinput.onblur=isChinese;
oNainput.onblur=isChinese;
//上传图片的处理
function setImagePreview(docObj,imgObjPreview,localImagId) {
            if(docObj.files &&docObj.files[0])
            {
                //火狐下，直接设img属性/
                // imgObjPreview.style.display = 'block';
                // imgObjPreview.style.width = '100px';
                // imgObjPreview.style.height = '120px';

                //imgObjPreview.src = docObj.files[0].getAsDataURL();

                //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
                imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
            }
            else
            {
                //IE下，使用滤镜
                docObj.select();
                var imgSrc = document.selection.createRange().text;
                var localImagId = document.getElementById("localImag");
                //必须设置初始大小
                localImagId.style.width = "100px";
                localImagId.style.height = "100px";
                //图片异常的捕捉，防止用户修改后缀来伪造图片
                try{
                    localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                }
                catch(e)
                {
                    alert("您上传的图片格式不正确，请重新选择!");
                    return false;
                }
                imgObjPreview.style.display = 'none';
                document.selection.empty();
                alert(imgSrc);
            }
            return true;
        }
oBtn1.onchange=function(){
   setImagePreview(oBtn1,oImg,oBtn1photo);
}

//获取openId
var addr=window.location.search;
var openid =addr.split("=")[1];
//alert(openid);
//获取性别
function getSex(){
    var value="";
    var radio=document.getElementsByName("sex");
    for(var i=0;i<radio.length;i++){
        if(radio[i].checked==true){
            value=radio[i].value;
            break;
        }
    }
    return value;
    }


//点击获取验证码按钮发起ajax请求
$('#getCode').click(function(){
    $.ajax({
        type:"GET",
        url:"http://weixin.ppplans.com/vipcard/getCode?phone="+$("#phone").val(),
        dataType:"jsonp",
        jsonpCallback:"callback"
        // success:function(data){
        //     if(data.error==1){
        //         alert('注册成功');
        //         //成功就跳转到我的会员信息页面
        //         window.location.href = "Memberinformation.html";
        //     }
        //     if(data.error==0){
        //         if(data.errmsg=='验证码失效'){
        //             alert('验证码失效');
        //         }
        //         else if(data.errmsg=='验证码错误'){
        //             alert('验证码错误');
        //         }
        //         else if(data.errmsg=='激活码错误'){
        //             alert('激活码错误');
        //         }
        //     }
		// },
		// error:function(){
		// 	alert("获取数据失败！");
		// }
    })
});

//点击确认提交发起ajax请求，成功跳转到我的会员信息页面
$("#btn2").click(function(){
    var sexValue=getSex();
	$.ajax({
		type:"GET",
        url:"http://weixin.ppplans.com/vipcard/register?jsonCallBack=callback&openId="+openid+"&userName="+$("#name").val()+"&userSex="+sexValue+"&userSchool="+$("#school").val()+"&userMajor="+$("#major").val()+"&phone="+$("#phone").val()+"&verifCode="+$("#ver-input").val()+"&activeCode="+$("#number-active-input").val()+"&userPhoto=http://oy8bqp4q7.bkt.clouddn.com/photo",
//        url:"http://localhost:8080/register?jsonCallBack=callback&openId="+openid+"&userName="+$("#name").val()+"&userSex="+sexValue+"&userSchool="+$("#school").val()+"&userMajor="+$("#major").val()+"&phone="+$("#phone").val()+"&verifCode="+$("#ver-input").val()+"&activeCode="+$("#number-active-input").val()+"&userPhoto=http://oy8bqp4q7.bkt.clouddn.com/photo",
        dataType:"jsonp",
		jsonpCallback:"callback",
		success:function(data){
            if(data.error==1){
                alert('注册成功');
                //成功就跳转到我的会员信息页面
                window.location.href = "MemberInformation.html"+"?openId="+openid;
            }
            if(data.error==0){
                if(data.errmsg=='验证码失效'){
                    alert('验证码失效');
                }
                else if(data.errmsg=='验证码错误'){
                    alert('验证码错误');
                }
                else if(data.errmsg=='激活码错误'){
                    alert('激活码错误');
                }
            }
		},
		error:function(){
			alert("获取数据失败！");
		}
	})
})

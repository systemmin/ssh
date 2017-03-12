<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>人脸识别</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body style="background: rgba(221, 234, 17, 0.32);">
	<header class="head">
		人脸识别系统<br /> <img src="imgs/pson.png" height="200px" width="1000px" />
	</header>
	<section style="text-align: center;">
		<form action="${pageContext.request.contextPath}/servlet/FileServlet" method="post" enctype="multipart/form-data"
			id="form">
			<a href="javasprict:;">点击上传图片</a><br /> <input type="file"
				name="file" style="display: none;" onchange="saveFile();" /><br/>
		</form>
	</section>
	<div class="foot clear">
		<div class="f1">
			<div class="div" id="din"></div>
			<img id="in" alt="" src=${fileName!=null?fileName:"imgs/shili.jpg"}
				width="400px" height="400px" onload="faceDao();">
		</div>
		<div class="f2"></div>
	</div>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			/* 事件转移，点击a标签上传文件 */
			$("a").click(function() {
				$("[type='file']").click();
			});
			
		
		});
			/* 当文件选择之后执行提交跳转到file.jsp提交 */
		function saveFile() {
			$("#form").submit();
		}
		
		/* 当img图片加载出来，异步执行人脸识别，跳转到servlet */
		function faceDao() {
			var msg = $("#in").attr("src");
					$.ajax({
						type : "post",
						url : "servlet/FaceServlet",
						data : {
							"path" : msg
						},
						dateType : "json",
						success : function(str) {
							if (str != null && str != undefined && str != '') {
								if (str.faces[0] != null
										&& str.faces[0] != undefined) {
									var glass = str.faces[0].attributes.glass.value;
									var glasse = "";
									if (glass == 'None') {
										glasse = "未带眼镜";
									} else if (glass == 'Dark') {
										glasse = "墨镜";
									} else {
										glasse = "普通眼镜";
									}
									var smile1 = str.faces[0].attributes.smile.threshold;
									var smile2 = str.faces[0].attributes.smile.value;
									var age = str.faces[0].attributes.age.value;
									var sex = str.faces[0].attributes.gender.value;
									var gender = sex == 'Male' ? '男' : '女';
									var num = "性别：" + gender + "<br/>是否佩戴眼镜："
											+ glasse + "<br/>笑点：" + smile1
											+ "<br/>笑值：" + smile2 + "<br/>年龄："
											+ age;
									$(".f2").append(num);
								} else {
									che();
								}
							} else {
								che();
							}
							/* 删除动画 */
							$("#din").removeClass("div");
						}
					});
						
		}
		function che() {
				var num = "性别：无<br/>是否佩戴眼镜:无<br/>笑点:无<br/>笑值:无<br/>年龄:无<br/>图片有误，<br/>2MB限制，"
						+ "<br/>图片格式：JPG(JPEG)，PNG"
						+ "<br/>图片像素尺寸：最小48*48像素，最大4096*4096像素"
						+ +"<br/>图片文件大小：2MB";
				$(".f2").append(num);
			}
		
	</script>
</body>
</html>

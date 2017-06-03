window.onload=function(){
	document.getElementsByClassName('submit-btn')[0].onclick=function(){
		var input = document.getElementsByTagName('input');
		if (input[0].value == '' || input[1].value == '') {
			alert('请输入用户名或密码!');
		}
	}
}
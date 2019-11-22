	// 背景图片随机切换
	function changeImg() {
		var r = Math.floor(Math.random() * 4) + 1;
		document.getElementById('bg_img').src = './images/homePage' + r
				+ '.jpg';
	}
	setInterval(changeImg, 10000);
	// 清除图标在输入框空内容时隐藏
	function clearHidden() {
		if (document.getElementById('username').value.length <= 0) {
			document.getElementById('clear').style.visibility = 'hidden';
		} else {
			document.getElementById('clear').style.visibility = 'visible';
		}
	}
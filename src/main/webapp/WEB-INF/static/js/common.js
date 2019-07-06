/**
 * 以post方式发送json数据
 * 
 * @param url
 *            要发送的url
 * @param date
 *            发送的数据
 * @returns ture 成功 false 失败
 */
function sendJsonByPost(url, date) {
	var res = false;
	if (url && date) {

		$.ajax({
			url : url,
			type : "POST",
			async: false,
			contentType : "application/json",
			cache : false,
			data : JSON.stringify(date),
			success : function(result) {
				if (result.state == 200) {
					res = true;
				}
				if (result.state == 500) {
					
				}
			}
		});

		return res

	} else {
		return false;
	}

}
/**
 * 以get方式发送json数据
 * 
 * @param url
 *            要发送的url
 * @param date
 *            发送的数据
 * @returns ture 成功 false 失败
 */

function sendDateByGet(url, date) {
	var res = false;
	if (url && date) {

		$.ajax({
			url : url,
			type : "GET",
			async: false,
			cache : false,
			data : date,
			success : function(result) {
				if (result.state == 200) {
					res = true;
				}
				if (result.state == 500) {
					res = false;
				}
			}
		});

		return res;
	} else {
		return false;
	}

}

function sendDateByPost(url, date) {
	var res = false;
	if (url && date) {

		$.ajax({
			url : url,
			type : "POST",
			async: false,
			cache : false,
			data : date,
			success : function(result) {
				if (result.state == 200) {
					res = true;
				}
				if (result.state == 500) {
					res = false;
				}
			}
		});
		return res;
	} else {
		return false;
	}

}
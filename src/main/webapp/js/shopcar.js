$(function(){

		
		var ckboxall = $("#ckboxall");
		var ckbox = $(".ckbox");
		var sub = $(".sub"); 
		var add = $(".add"); 
		var num = $(".num");
		var spnum = $("#spnum");
		
setInterval(function(){
	var spn = Number(0);
	ckbox.each(function(){
		if($(this).attr("checked")){
			var onep = $(this).parent().next().next().next().children().val();
			spn = spn + Number(onep);
		}
	});
	spnum.html(spn);
}, 10);

	


				

//加减数量和正则	
	num.each(function(){	
		var reg = /^\d+$/;
		var cn = Number();
		var oneprice = $(this).parent().prev().prev().children().html();
		var price = $(this).parent().prev().children();


		$(this).focus(function(){
			cn = $(this).val();
		});
		$(this).blur(function(){
			if(reg.test($(this).val())){
				price.val(oneprice*$(this).val());
			}else{
				$(this).val(cn);
			}
		});
	});
//减号
	sub.click(function(){
		var n = $(this).next();
		var oneprice = n.parent().prev().prev().children().html();
		var price = n.parent().prev().children();

		var nu = parseInt(n.val())-1;
		if($(this).next().val() == 0){
			$(this).next().val(0);
			price.val(oneprice*n.val());
		}
		else{	
			$(this).next().val(nu);
			price.val(oneprice*n.val());
		}
	});
//加号	
	add.click(function(){
		var n = $(this).prev();
		var oneprice = n.parent().prev().prev().children().html();
		var price = n.parent().prev().children();

		var nu = parseInt(n.val())+1;
		if($(this).prev().val() == 0){
			$(this).prev().val(nu);
			price.val(oneprice*n.val());
		}
		else{
			$(this).prev().val(nu);
			price.val(oneprice*n.val());
		}
	});



//全选框
		ckboxall.click(function(){
			if(ckboxall.attr("checked")){

				ckbox.each(function(){
					$(this).attr("checked",true);
				});
			}else{
				ckbox.each(function(){
					$(this).attr("checked",false);
				});
			}
		});	
//单选框		
		ckbox.click(function(){
			var boob = true;
			ckbox.each(function(){	
				if(!$(this).attr("checked")){
					boob = false;
				}
			});
			if(boob){
				ckboxall.attr("checked",true);
			}else{
				ckboxall.attr("checked",false);
			}

		});






	});

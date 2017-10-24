$(function(){
	$.ajax({
		url:"http://localhost:8080/Reception/testSheng1.do",
		type:"post",
		dataType:"jsonp",
		success:function(data,str){
			console.log("success data:"+JSON.stringify(data)+" str:"+str);
			var html="";
			for (var i=0;i<data.length;i++) {
				var _data=data[i];
				if(i==0){
					html+="<option selected='selected'>"+_data.name+"</option>"
				}else{
					html+="<option>"+_data.name+"</option>"
				}
			}
			$("#select1").html(html);
			
			//获取省下的所有的市
			var shiList=data[0].shiList;
			var html_shi="";
			for (var i=0;i<shiList.length;i++) {
				var _shi=shiList[i];
				if(i==0){
					html_shi+="<option selected='selected'>"+_shi.name+"</option>";
				}else{
					html_shi+="<option>"+_shi.name+"</option>";
				}
			}
			$("#select2").html(html_shi);
			
			//获取第一个型号下的价格
			var _price=shiList[0].price;
			$("#select3").html("<option selected='selected'>"+_price+"</option>");
			
			$("#select1").change(function(){
				//获取被选择的品牌的下标
				var _index=$("#select1 option").index($("#select1 option:selected"));
				//根据下标获取品牌
				var _brand=data[_index];
				//获取品牌下的型号集合
				var _shi=_brand.models;
				
				var html_model="";
				for (var i=0;i<_models.length;i++) {
					var _model=_models[i];
					if(i==0){
						html_model+="<option selected='selected'>"+_model.name+"</option>";
					}else{
						html_model+="<option>"+_model.name+"</option>";
					}
					
					var _model=_models[0];
					//改变价格
					$("#select3").html("<option selected='selected'>"+_model.price+"</option>")
				}
				
				$("#select2").html(html_model);
				$("#select2").change(function(){
					//获取被选择的型号的下标
					var _index=$("#select2 option").index($("#select2 option:selected"));
					//根据下标获取具体的型号
					var _model=_models[_index];
					//改变价格
					$("#select3").html("<option selected='selected'>"+_model.price+"</option>")
				});
			})
		},
		
		complete:function(data,str){
			console.log("conlete data:"+data+" str:"+str);
		}
	})
})

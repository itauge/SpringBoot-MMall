$(function(){
    //计算总价
    var array = $(".qprice");
    var totalCost = 0;
    for(var i = 0;i < array.length;i++){
        var val = parseInt($(".qprice").eq(i).html().substring(1));
        totalCost += val;
    }
    $("#totalprice").html("￥"+totalCost);
    //settlement2使用
    $("#settlement2_totalCost").val(totalCost);
});

//商品数量++
// function addQuantity(obj){
//     var index = $(".car_btn_2").index(obj);
//     var stock = parseInt($(".productStock").eq(index).val());
//     var price = parseInt($(".productPrice").eq(index).val());
//     var inputObj = $(".car_ipt").eq(index);
//     var quantity = inputObj.val();
//     var id = $(".id").eq(index).val();
//     ++quantity;
//     if(quantity > stock){
//         quantity = stock;
//         alert("库存不足！");
//     }
//     var cost = quantity*price;
//     $.ajax({
//         url:"/product/updateCart/"+id+"/"+quantity+"/"+cost,
//         type:"POST",
//         dataType:"text",
//         success:function (data) {
//             if(data == "success"){
//                 //更新toSettlement的数据
//                 $(".qprice").eq(index).html("￥"+cost);
//                 inputObj.val(quantity);
//                 if(quantity < stock){
//                     var totalCost = parseInt($("#totalprice").html().substring(1));
//                     totalCost += price;
//                     $("#totalprice").html("￥"+totalCost);
//                 }
//                 //更新searchBar的数据
//                 $(".quantity").eq(index).text(quantity);
//                 $(".cost").eq(index).text(cost);
//
//                 var array = $(".cost");
//                 var totalCost = 0;
//                 for(var i = 0;i < array.length;i++){
//                     var val = parseInt($(".cost").eq(i).html());
//                     totalCost += val;
//                 }
//                 $("#totalCost").html("￥"+totalCost);
//             }
//         }
//     });
// }


//商品數量++
function  addQuantity(obj){
    let index = $(".car_btn_2").index(obj);
    let quantity = parseInt($(".car_ipt").eq(index).val());
    let stock = parseInt($(".productStock").eq(index).val());
    if (quantity == stock){
        alert("庫存不足");
        return false;
    }
    quantity++;
    let price = parseFloat($(".productPrice").eq(index).val());
    let cost = quantity * price;
    let id = parseInt($(".id").eq(index).val());


    //將最新的quantity cost發送給後臺，動態更新數據庫
    //基於JQuery的Ajax
    //基於js的Ajax
    //基於Vue的axios

    $.ajax({
        url:"/cart/update/"+id+"/"+quantity+"/"+cost,
        type:"POST",
        success:function (data){
         if (data == "success"){
             $(".qprice").eq(index).text('￥'+cost);
             $(".car_ipt").eq(index).val(quantity);

             //计算总价
             var array = $(".qprice");
             var totalCost = 0;
             for(var i = 0;i < array.length;i++){
                 var val = parseInt($(".qprice").eq(i).html().substring(1));
                 totalCost += val;
             }
             $("#totalprice").html("￥"+totalCost);
         }
        }

    });




}

//商品数量--
// function subQuantity(obj){
//     var index = $(".car_btn_1").index(obj);
//     var price = parseInt($(".productPrice").eq(index).val());
//     var inputObj = $(".car_ipt").eq(index);
//     var quantity = inputObj.val();
//     var id = $(".id").eq(index).val();
//     --quantity;
//     if(quantity == 0){
//         quantity = 1;
//     }
//     var cost = quantity*price;
//     $.ajax({
//         url:"/product/updateCart/"+id+"/"+quantity+"/"+cost,
//         type:"POST",
//         dataType:"text",
//         success:function(data){
//             if(data == "success"){
//                 $(".qprice").eq(index).html("￥"+cost);
//                 inputObj.val(quantity);
//                 if(quantity!=1){
//                     var totalCost = parseInt($("#totalprice").html().substring(1));
//                     totalCost -= price;
//                     $("#totalprice").html("￥"+totalCost);
//                 }
//                 $(".quantity").eq(index).text(quantity);
//                 $(".cost").eq(index).text(cost);
//
//                 var array = $(".cost");
//                 var totalCost = 0;
//                 for(var i = 0;i < array.length;i++){
//                     var val = parseInt($(".cost").eq(i).html());
//                     totalCost += val;
//                 }
//                 $("#totalCost").html("￥"+totalCost);
//             }
//         }
//     });
// }

//商品數量--
function subQuantity(obj){
   let index = $(".car_btn_1").index(obj);
   let quantity = parseInt($(".car_ipt").eq(index).val());
   if (quantity == 1){
       alert("至少選擇一件商品")
       return false;
   }
   quantity--;
    let price = parseFloat($(".productPrice").eq(index).val());
    let cost = quantity * price;
    let id = parseInt($(".id").eq(index).val());

    $.ajax({
        url:"/cart/update/"+id+"/"+quantity+"/"+cost,
        type:"POST",
        success:function (data){
            if (data == "success"){
                $(".qprice").eq(index).text('￥'+cost);
                $(".car_ipt").eq(index).val(quantity);

                //计算总价
                var array = $(".qprice");
                var totalCost = 0;
                for(var i = 0;i < array.length;i++){
                    var val = parseInt($(".qprice").eq(i).html().substring(1));
                    totalCost += val;
                }
                $("#totalprice").html("￥"+totalCost);
            }
        }

    });




}
//移出购物车
function removeCart(obj){
    var index = $(".delete").index(obj);
    var id = parseInt($(".id").eq(index).val());
    if(confirm("Are you sure to delete the item？")){
        window.location.href = "/cart/deleteById/"+id;
    }
}

function settlement2(obj){
    let totalCost = $("#totalprice").text();
    if (totalCost == "￥0"){
        alert("購物車爲空，不能結算");
        return false;
    }
        window.location.href = "/cart/settlement2";

}
DetailController = {
    model:"",
    url: "",

    getRequestData: function() {
        var request = location.href.split("?")[1];

        this.model = request.split("=")[0];
        var value = request.split("=")[1];

        this.url = `/user/expenses/${this.model}/detail/${value}`;
    },

    getData: function() {
        that =this;

        this.getRequestData();
        var url = this.url;

        console.log(this.model + "---" + url);

        Ae.trans.AJAX({
            type: "POST",
            url: url,
            async: true,
        }, callback)
    
        function callback(xmls) {
            jsonName = xmls.responseText;
            data = JSON.parse(jsonName);

            
            that.wrapperDetail(data);
        }
    },

    wrapperDetail: function(data) {
        console.log(data)

        if(this.model == "apply") {
            var apply = `<ul class="detail-items">
                <li><i>费用编号：</i>${data.identifier}</li>
                <li><i>归属类别：</i>${data.ascription}</li>
                <li><i>费用金额：</i>￥${data.amount}</li>
                <li><i>报支事项：</i>${data.matter}</li>
                <li><i>归属人：</i>${data.ascriptor}</li>
                <li><i>经办人：</i>${data.handler}</li>
                <li><i>项目名称：</i>${data.projectName}</li>
                <li><i>收款单位：</i>${data.receiveCompany}</li>
                <li><i>申请时间：</i>${Ae.date.format(data.expensesGmt,'yyyy-MM-dd')}</li>
                <li><i>部门类别：</i>${data.departmentType}</li>
                <li><i>费用分类：</i>${data.expensesType}</li>
                <li><i>项目编号：</i>${data.projectNum}</li>         
                <li><i>分类标识：</i>${data.classType}</li>
                <li><i>申报备注：</i>${data.remark}</li>
                <li><i>创建日期：</i>${Ae.date.format(data.gmtCreate,'yyyy-MM-dd')}</li>
                <li><i>申报状态：</i>${data.applyStatus}</li>

                <a class="btn-default frt" href="/list">返回列表</a>
            </ul>`

            var detail = document.getElementsByClassName('detail-body')[0];
            detail.innerHTML = apply;

        } else if(this.model == "payment") {
            var payment = `<ul class="detail-items">
                <li><i>费用编号：</i>${data.identifier}</li>
                <li><i>费用金额：</i>￥${data.amount}</li>
                <li><i>报支事项：</i>${data.paymentType}</li>
                <li><i>归属类别：</i>${data.paymentBank}</li>
                <li><i>支付时间：</i>${Ae.date.format(data.paymentGmt,'yyyy-MM-dd')}</li>
                <li><i>经办人：</i>${data.handler}</li>
                <li><i>凭证号：</i>${data.voucher}</li>
                <li><i>创建日期：</i>${Ae.date.format(data.gmtCreate,'yyyy-MM-dd')}</li>

                <a class="btn-default frt" href="/list">返回列表</a>
            </ul>`

            var detail = document.getElementsByClassName('detail-body')[0];
            detail.innerHTML = payment;
        }
    },

    _init: function() {
        this.getData();
    }
}

DetailController._init();
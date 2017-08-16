function _deleteConfirmScript(){

    this.deleteUser = function(id){
        if (confirm("Are you sure you want to delete this user?")){
            window.location = "/admin/usermanagement/removeuser/" + id;
        }
    };

    this.deleteBaseTableRecord = function(id){
        if (confirm("Are you sure you want to delete this record?")){
            window.location = "/basetableconroller/removebasetablerecord/" + id;
        }
    };

    this.deleteStatusOfDealRecord = function(id){
        if (confirm("Are you sure you want to delete this Status of Deal?")){
            window.location = "/admin/statusofdealmanagement/removestatusofdeal/" + id;
        }
    };

    this.deleteStatusOfCallRecord = function(id){
        if (confirm("Are you sure you want to delete this Status of Call?")){
            window.location = "/admin/statusofcallmanagement/removestatusofcall/" + id;
        }
    };
}
var deleteScript = new _deleteConfirmScript();

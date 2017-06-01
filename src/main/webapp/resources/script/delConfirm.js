function _deleteConfirmScript(){

    this.deleteUser = function(id){
        if (confirm("Are you sure you want to delete this user?")){
            window.location = "/admin/removeuser/" + id;
        }
    };

    this.deleteBaseTableRecord = function(id){
        if (confirm("Are you sure you want to delete this record?")){
            window.location = "/basetableconroller/removebasetablerecord/" + id;
        }
    }
}
var deleteScript = new _deleteConfirmScript();

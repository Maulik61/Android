package com.example.dottcomm.fireapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dottcomm on 3/25/2017.
 */
//CALL
compile 'com.squareup:otto:1.3.8'


public class WebService {
    static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("ANY_URI").setLogLevel(RestAdapter.LogLevel.FULL).build();
    private static login_api loginApi;
    private static Order_Model order_model;

    public static login getLoginApi() {
        if (loginApi == null) loginApi = restAdapter.create(login_api.class); //ogin_Api is the interface class
        return loginApi;
    }

    public static Order getOrder() {
        if (order_model == null) order_model = restAdapter.create(Order_Model.class); //Order_Model is Interface Class
        return order_model;
    }

}
//GET
public interface login {

    @GET("/login.json/UserName={username}/Password={password}")
    public void login(@Path("username") String username, @Path("password") String password, Callback<List<LoginResponce>> response);
}




//POST
    @POST("/Save.json")
    public void Save(@Body Save_Request saveOrdersAttribute, Callback<Save_Response> response);



// Request DATA
public class Save_Request {

    public List<Save_Request.OrderDataList> getOrderDataList() {
        return OrderDataList;
    }

    private List<OrderDataList> OrderDataList;


    public Save_Request() {
        this.OrderDataList = new ArrayList<OrderDataList>();
    }

    public void addOrdersAttribute(String itemName, String bitisComplete, String bitisKot, String decitemWisePrice, String decitemWisePriceWithTax, String intbranchID, String intcustomerID,
                                   String intitemID, String intkotNo, String intorderID, String intorderType, String strdateString, String strtableNo, String difference, String Oldquantity, String intuserid,
                                   String IsinnerKot, String intquantity) {
        this.OrderDataList.add(new OrderDataList(itemName, bitisComplete, bitisKot, decitemWisePrice, decitemWisePriceWithTax, intbranchID, intcustomerID,
                intitemID, intkotNo, intorderID, intorderType, strdateString, strtableNo, difference, Oldquantity, intuserid,
                IsinnerKot, intquantity));
    }

    public class OrderDataList {

        private String ItemName;
        private String bitIsComplete;
        private String bitIsKot;
        private String decItemWisePrice;
        private String decItemWisePriceWithTax;
        private String intBranchID;
        private String intCustomerID;
        private String intItemID;
        private String intKotNo;
        private String intOrderID;
        private String intOrderType;
        private String strDateString;
        private String strTableNo;
        private String Difference;
        private String OldQuantity;
        private String intUserid;
        private String IsInnerKot;
        private String intQuantity;
        private List<orderAttributeDataObject> OrderAttributeDataObject;


        public List<orderAttributeDataObject> getOrderAttributeDataObject() {
            return OrderAttributeDataObject;
        }
        public orderAttributeDataObject setOrderAttributeDataObject(){
            return (new orderAttributeDataObject(""));
        }

        OrderDataList(String itemName, String bitisComplete, String bitisKot, String decitemWisePrice, String decitemWisePriceWithTax, String intbranchID, String intcustomerID,
                      String intitemID, String intkotNo, String intorderID, String intorderType, String strdateString, String strtableNo, String difference, String Oldquantity, String intuserid,
                      String IsinnerKot, String intquantity) {

            this.ItemName = itemName;
            this.bitIsComplete = bitisComplete;
            this.bitIsKot = bitisKot;
            this.decItemWisePrice = decitemWisePrice;
            this.decItemWisePriceWithTax = decitemWisePriceWithTax;
            this.intBranchID = intbranchID;
            this.intCustomerID = intcustomerID;
            this.intItemID = intitemID;
            this.intKotNo = intkotNo;
            this.intOrderID = intorderID;
            this.intOrderType = intorderType;
            this.strDateString = strdateString;
            this.strTableNo = strtableNo;
            this.Difference = difference;
            this.OldQuantity = Oldquantity;
            this.intUserid = intuserid;
            this.IsInnerKot = IsinnerKot;
            this.intQuantity = intquantity;
            this.OrderAttributeDataObject = new ArrayList<orderAttributeDataObject>();
        }


        public void insert(String AttributeName,String attributePrice,String attributeQuantity,String difference, String attrIsKot,String itemAttributeID,String oldQuantity,String orderAttributeID,String orderAttributeRate,String orderID){
            this.OrderAttributeDataObject.add(new orderAttributeDataObject(AttributeName,attributePrice,attributeQuantity,difference, attrIsKot,itemAttributeID,oldQuantity,orderAttributeID,orderAttributeRate,orderID));
        }
        public class orderAttributeDataObject {
            private String AttributeName;
            private String AttributePrice;
            private String AttributeQuantity;
            private String Difference;
            private String IsKot;
            private String ItemAttributeID;
            private String OldQuantity;
            private String OrderAttributeID;
            private String OrderAttributeRate;
            private String OrderID;
            private String sObject;
            public orderAttributeDataObject(String object){
                this.sObject = object;
            }
            public orderAttributeDataObject(String attributeName,String attributePrice,String attributeQuantity,String difference, String attrIsKot,String itemAttributeID,String oldQuantity,String orderAttributeID,String orderAttributeRate,String orderID){
                this.AttributeName=attributeName;
                this.AttributePrice=attributePrice;
                this.AttributeQuantity=attributeQuantity;
                this.Difference=difference;
                this.IsKot= attrIsKot;
                this.ItemAttributeID=itemAttributeID;
                this.OldQuantity=oldQuantity;
                this.OrderAttributeID=orderAttributeID;
                this.OrderAttributeRate=orderAttributeRate;
                this.OrderID= orderID;
            }
        }

    }

}
public class Save_Response {
    @SerializedName("SaveResult")
    private String SaveResult;

    public String getSaveResult() {
        return SaveResult;
    }

    public void setResult(String saveResult) {
        SaveResult = saveResult;
    }
}
    
//POst Begin Call
     testCmt tv = new testCmt("","",0,0,"test","");
        Webservice.getTest_model().getcmt(tv, new Callback<TestCmt_Response>() {
            @Override
            public void success(TestCmt_Response testCmt_Response, Response response) {
                Log.e("Test", "success: ");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Test", "Error: ");
            }
        });
//Post end call
public interface Test_Model {

    @POST("/SaveCmt.json")
    public void getcmt(@Body testCmt cmt,Callback<TestCmt_Response> response);

    @POST("/GetCmr.json")
    public void getData(@Body BranchRequest rnt, Callback<GetBranchReponse> response);
}
public class testCmt{
    private List<Comment> comment = new ArrayList<Comment>();


    public testCmt(double decItemRating, String dteItemFeedBack, int intCustomerID, int intItemID, String strItemFeedback, String strItemImagePath){
        this.comment.add(new Comment(decItemRating,dteItemFeedBack,intCustomerID,intItemID,strItemFeedback,strItemImagePath));
    }
    public class Comment{

        private Double decItemRating;
        private String dteItemFeedBack;
        private int intCustomerID;
        private int intItemID;
        private String strItemFeedback;
        private String strItemImagePath;

        public Comment(Double decItemRating, String dteItemFeedBack, int intCustomerID, int intItemID, String strItemFeedback, String strItemImagePath) {
            this.decItemRating = decItemRating;
            this.dteItemFeedBack = dteItemFeedBack;
            this.intCustomerID = intCustomerID;
            this.intItemID = intItemID;
            this.strItemFeedback = strItemFeedback;
            this.strItemImagePath = strItemImagePath;
        }
    }
}
public class TestCmt_Response {
    @SerializedName("SaveResult")
    private String SaveResult;

    public String getSaveResultt() {
        return SaveResult;
    }

    public void setSaveResult(String SaveResult) {
        SaveResult = SaveResult;
    }
}


    
//begin post call
        BranchRequest b = new BranchRequest("","0","0","","");
        Webservice.getTest_model().getData(b, new Callback<GetReponse>() {
                    @Override
                    public void success(GetReponse getReponse, Response response) {
                        Log.e("Test", "success: ");
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("Test", "failure: ");
                    }
                });
//End post call
public class BranchRequest {

    private DataObject DataObject;

    public DataObjectRequest (String strCustomerlatLong, String intCityId, String intID, String strSearchString, String strTag){

        this.DataObject = new DataObject(strCustomerlatLong,intCityId,intID,strSearchString,strTag);

    }

    public classDataObject{
        private String strCustomerlatLong;
        private String intCityId;
        private String intID;
        private String strSearchString;
        private String strTag;

        public BranchSearchDataObject(String strCustomerlatLong, String intCityId, String intID, String strSearchString, String strTag) {
            this.strCustomerlatLong = strCustomerlatLong;
            this.intCityId = intCityId;
            this.intID = intID;
            this.strSearchString = strSearchString;
            this.strTag = strTag;
        }
    }

}
public class GetResultReponse {

    @SerializedName("Result")
    private List<GetResult> GetResult = new ArrayList<GetResult>();
    public List<GetResult> GetResultData() {
        return GetResult;
    }

    public void setResultData(List<GetResult> Result) {
        this.GetResult = Result;
    }
    public class GetResult{
            public String BillLineData;
            public String bitIsApprove;
            public String bitIsConsumerOn;
            
        public GetResult(String billLineData, String bitIsApprove, String bitIsConsumerOn){
            this.BillLineData = billLineData;
            this.bitIsApprove = bitIsApprove;
            this.bitIsConsumerOn = bitIsConsumerOn;
          
        }
    }
}



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



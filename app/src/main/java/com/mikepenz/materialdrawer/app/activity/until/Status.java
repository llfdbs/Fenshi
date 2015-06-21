package com.mikepenz.materialdrawer.app.activity.until;

/**
 * Created by lilongfei on 15/4/26.
 */
public class Status {

    public final static String TYPE = "type";
    public final static String TITLE = "title";
    public final static String ORDER_TYPE = "order_type";


    final public static String SUCCESS = "200";
    public final static int SCANNIN_GREQUEST_CODE = 1;



    public enum PageType {
        TICKET(1),ORDER(0),COLLECTION(2),HLEP(3),CLEARCAR(4),STORELIST(5);
        int type = -1;

        PageType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public static PageType getEnum(int type){
            for (PageType page : PageType.values()){
                if (type == page.getType())
                    return page;
            }
            return TICKET;
        }

    }
}

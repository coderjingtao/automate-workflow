package com.joseph.newnetsuite.constant;

/**
 * @author Joseph.Liu
 */
public interface WorkFlowNodes {

    Integer getNodeNo();

    String getDesc();

    enum SalesOrderNodes implements WorkFlowNodes{
        /**
         *
         */
        ADD_SO(1,"Add Sales Order to NetSuite"),
        /**
         *
         */
        ADD_FULFILL(2,"Add Fulfillment to NetSuite"),
        /**
         *
         */
        ADD_INVOICE(3,"ADD INVOICE to NetSuite"),
        ;

        private final Integer nodeNo;
        private final String desc;

        SalesOrderNodes(Integer nodeNo, String desc){
            this.nodeNo = nodeNo;
            this.desc = desc;
        }

        @Override
        public Integer getNodeNo() {
            return nodeNo;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }

    enum RefundNodes implements WorkFlowNodes{
        /**
         *
         */
        MATCH_INVOICE(1,"match invoice"),
        /**
         *
         */
        ADD_CM(2,"add credit memos"),
        /**
         *
         */
        ADD_REFUND(3,"add customer refunds"),
        ;

        private final Integer nodeNo;
        private final String desc;

        RefundNodes(Integer nodeNo, String desc){
            this.nodeNo = nodeNo;
            this.desc = desc;
        }

        @Override
        public Integer getNodeNo() {
            return nodeNo;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }
}

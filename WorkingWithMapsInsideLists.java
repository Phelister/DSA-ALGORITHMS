/*package com.myProjects.wow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkingWithMapsInsideLists {
    public List<Map<String, Object>> getAll(List<Map<String, Object> book) {

        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> innerRow = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < innerRow.size(); j++) {
                Integer customerAccountNumber = (Integer) data.get(0).get("customerAccountNumber");
                Integer customerId = (Integer) data.get(0).get("customerId");
                Integer serviceProfileID = (Integer) data.get(0).get("serviceProfileID");
                Integer partnerId = (Integer) data.get(0).get("partnerId");
                String customerName = (String) data.get(0).get("customerName");
                String TariffName = (String) data.get(0).get("TariffName");
                String email = (String) data.get(0).get("email");
                String Opcode1;
                String smsPerServingNetwork1;
                String dataUsagePerServingCountry1;
                String dataAmount1;
                String quantityUsedSMS1;
                String smsAmount1;
                String quantityOfActiveSimcards1;
                String Opcode2;
                String smsPerServingNetwork2;
                String dataUsagePerServingCountry2;
                String dataAmount2;
                String quantityUsedSMS2;
                String smsAmount2;
                String quantityOfActiveSimcards2;
                String Opcode3;
                String smsPerServingNetwork3;
                String dataUsagePerServingCountry3;
                String dataAmount3;
                String quantityUsedSMS3;
                String smsAmount3;
                String quantityOfActiveSimcards3;
                String Opcode4;
                String smsPerServingNetwork4;
                String dataUsagePerServingCountry4;
                String dataAmount4;
                String quantityUsedSMS4;
                String smsAmount4;
                String quantityOfActiveSimcards4;
                String Opcode5;
                String smsPerServingNetwork5;
                String dataUsagePerServingCountry5;
                String dataAmount5;
                String quantityUsedSMS5;
                String smsAmount5;
                String quantityOfActiveSimcards5;
                String Opcode6;
                String smsPerServingNetwork6;
                String dataUsagePerServingCountry6;
                String dataAmount6;
                String quantityUsedSMS6;
                String smsAmount6;
                String quantityOfActiveSimcards6;
                String Opcode7;
                String smsPerServingNetwork7;
                String dataUsagePerServingCountry7;
                String dataAmount7;
                String quantityUsedSMS7;
                String smsAmount7;
                String quantityOfActiveSimcards7;
                String Opcode8;
                String smsPerServingNetwork8;
                String dataUsagePerServingCountry8;
                String dataAmount8;
                String quantityUsedSMS8;
                String smsAmount8;
                String quantityOfActiveSimcards8;
                String Opcode9;
                String smsPerServingNetwork9;
                String dataUsagePerServingCountry9;
                String dataAmount9;
                String quantityUsedSMS9;
                String smsAmount9;
                String quantityOfActiveSimcards9;
                String Opcode10;
                String smsPerServingNetwork10;
                String dataUsagePerServingCountry10;
                String dataAmount10;
                String quantityUsedSMS10;
                String smsAmount10;
                String quantityOfActiveSimcards10;
                String Opcode11;
                String smsPerServingNetwork11;
                String dataUsagePerServingCountry11;
                String dataAmount11;
                String quantityUsedSMS11;
                String smsAmount11;
                String quantityOfActiveSimcards11;
                String Opcode12;
                String smsPerServingNetwork12;
                String dataUsagePerServingCountry12;
                String dataAmount12;
                String quantityUsedSMS12;
                String smsAmount12;
                String quantityOfActiveSimcards12;
                String Opcode13;
                String smsPerServingNetwork13;
                String dataUsagePerServingCountry13;
                String dataAmount13;
                String quantityUsedSMS13;
                String smsAmount13;
                String quantityOfActiveSimcards13;
                String Opcode14;
                String smsPerServingNetwork14;
                String dataUsagePerServingCountry14;
                String dataAmount14;
                String quantityUsedSMS14;
                String smsAmount14;
                String quantityOfActiveSimcards14;

                if ((String) data.get(i).get(j) == "SAFKE") {
                    Opcode1 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork1 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry1 = (String) data.get(i).get("dataSummary");
                    dataAmount1 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS1 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount1 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards1 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "AIRUG") {
                    Opcode2 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork2 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry2 = (String) data.get(i).get("dataSummary");
                    dataAmount2 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS2 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount2 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards2 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "ATLRW") {
                    Opcode3 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork3 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry3 = (String) data.get(i).get("dataSummary");
                    dataAmount3 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS3 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount3 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards3 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "MTNUG") {
                    Opcode4 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork4 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry4 = (String) data.get(i).get("dataSummary");
                    dataAmount4 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS4 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount4 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards4 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "MTNZM") {
                    Opcode5 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork5 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry5 = (String) data.get(i).get("dataSummary");
                    dataAmount5 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS5 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount5 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards5 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "TIGRW") {
                    Opcode6 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork6 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry6 = (String) data.get(i).get("dataSummary");
                    dataAmount6 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS6 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount6 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards6 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "TNMMW") {
                    Opcode7 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork7 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry7 = (String) data.get(i).get("dataSummary");
                    dataAmount7 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS7 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount7 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards7 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "VFCD") {
                    Opcode8 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork8 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry8 = (String) data.get(i).get("dataSummary");
                    dataAmount8 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS8 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount8 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards8 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "VFTZ") {
                    Opcode9 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork9 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry9 = (String) data.get(i).get("dataSummary");
                    dataAmount9 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS9 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount9 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards9 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "WARUG") {
                    Opcode10 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork10 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry10 = (String) data.get(i).get("dataSummary");
                    dataAmount10 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS10 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount10 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards10 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "ZAICD") {
                    Opcode11 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork11 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry11 = (String) data.get(i).get("dataSummary");
                    dataAmount11 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS11 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount11 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards11 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "ZAIMW") {
                    Opcode12 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork12 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry12 = (String) data.get(i).get("dataSummary");
                    dataAmount12 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS12 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount12 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards12 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "ZAITZ") {
                    Opcode13 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork13 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry13 = (String) data.get(i).get("dataSummary");
                    dataAmount13 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS13 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount13 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards13 = (String) data.get(i).get("quantityOfActiveSimcards");

                } else if ((String) data.get(i).get(j) == "ZAIZM") {
                    Opcode14 = (String) data.get(i).get("opcode");
                    smsPerServingNetwork14 = (String) data.get(i).get("smsPerServingNetwork");
                    dataUsagePerServingCountry14 = (String) data.get(i).get("dataSummary");
                    dataAmount14 = (String) data.get(i).get("dataSummary");
                    quantityUsedSMS14 = (String) data.get(i).get("quantityUsedSMS");
                    smsAmount14 = (String) data.get(i).get("smsAmount");
                    quantityOfActiveSimcards14 = (String) data.get(i).get("quantityOfActiveSimcards");
                    String bill_ref = (String) data.get(i).get("bill_ref");
                }
            }


        }
        return data;
    }


    public static void main(String[] args) {

        WorkingWithMapsInsideLists wow = new WorkingWithMapsInsideLists();
        List<Map<String, Object> book = new List<Map<String, Object>>() {
        {
                "dataAmount":"No api input provided",
                "dataSummary":"0",
                "serviceProfileID":"100244900",
                "TariffName":"Global IOT - Pay Go",
                "invoicedAmount":"5985",
                "quantityOfActiveSimcards":null,
                "customerAccountNumber":"799320125",
                "opcode":"SAFKE",
                "customerName":"SFC_Texas_Track_Kenya_LTD",
                "billableItem":"5985",
                "customerId":"100214520",
                "smsAmount":"No api input provided",
                "partnerId":"100218790",
                "smsPerServingNetwork":"0",
                "quantityUsedSMS":"0",
                "email":"wwatitwa@safaricom.co.ke;msimiyu@safaricom.co.ke;ebarasa@safaricom.co.ke"
        },
        {
            "dataAmount":"No api input provided",
                "dataSummary":"0",
                "serviceProfileID":"100244900",
                "TariffName":"Global IOT - Pay Go",
                "invoicedAmount":"114135",
                "quantityOfActiveSimcards":null,
                "customerAccountNumber":"799320125",
                "opcode":"SAFKE",
                "customerName":"SFC_Texas_Track_Kenya_LTD",
                "billableItem":"114135",
                "customerId":"100214520",
                "smsAmount":"No api input provided",
                "partnerId":"100218790",
                "smsPerServingNetwork":"0",
                "quantityUsedSMS":"0",
                "email":"wwatitwa@safaricom.co.ke;msimiyu@safaricom.co.ke;ebarasa@safaricom.co.ke"
        }
    }
    }
}
*/

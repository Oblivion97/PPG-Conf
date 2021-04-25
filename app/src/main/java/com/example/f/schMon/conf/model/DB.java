/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.provider.BaseColumns;

/**
 * Created by Mir Ferdous on 02/08/2017.
 */

public class DB {
    /**
     * this is database contract class
     * in it DB schema is saved
     */

    public static String schools_table_create = "CREATE TABLE `schools` (\n" +
            "\t`_id`\t\n" +
            "\t`s_id`\t\n" +
            "\t`s_name`\t\n" +
            "\t`po_id`\t\n" +
            "\t`po_name`\t\n" +
            "\t`s_address`\t\n" +
            "\t`s_code`\t\n" +
            "\t`no_std`\t\n" +
            "\t`edu_type`\t\n" +
            "\t`time_lm`\t\n" +
            "\t`total_bill`\t\n" +
            "\t`paid`\tTEXT\n" +
            ");";


    private DB() {
    }


    //================= conf ======================================
    public static class speaker_new implements BaseColumns {
        public static final String table = "speaker_new";

        public static final String sl_no = "sl_no";
        public static final String name = "name";
        public static final String topic = "topic";
        public static final String working_session = "working_session";
        public static final String parallal_session = "parallal_session";
        public static final String venue = "venue";
        public static final String t_d = "t_d";


    }

    public static class speaker_all implements BaseColumns {
        public static final String table = "speaker_all";
        public static final String _id = "_id";
        public static final String sl = "sl";
        public static final String theme = "theme";
        public static final String name = "name";
        public static final String topic = "topic";
        public static final String country = "country";
        public static final String digit = "digit";
    }

    public static class topicwise implements BaseColumns {
        public static final String table = "topicwise";
        public static final String sl = "sl";
        public static final String theme = "theme";
        public static final String name = "name";
        public static final String topic = "topic";
    }


    public static class countrywise implements BaseColumns {
        public static final String table = "countrywise";
        public static final String sl = "sl";
        public static final String name = "name";
        public static final String theme = "theme";
        public static final String country = "country";
        public static final String digit = "digit";

    }

    public static class contributor implements BaseColumns {
        public static final String table = "contributor";
        public static final String sl = "sl";
        public static final String name = "name";
        public static final String designation = "designation";
        public static final String organization = "organization";
        public static final String mail = "mail";
    }


    //==================================== old ======================================================================
    public static class schools implements BaseColumns {
        public static final String table = "schools";
        public static final String s_id = "s_id";
        public static final String s_name = "s_name";
        public static final String po_id = "po_id";
        public static final String po_name = "po_name";
        public static final String s_address = "s_address";
        public static final String no_std = "no_std";
        public static final String s_code = "s_code";
        public static final String grade = "grade";
        public static final String edu_type = "edu_type";
        public static final String grade_id = "grade_id";
        public static final String institute_type = "institute_type";
        public static final String time_lm = "time_lm";
        public static final String total_bill = "total_bill";
        public static final String paid = "paid";


    }

    public static class students implements BaseColumns {
        public static final String table = "students";
        public static final String std_id = "std_id";
        public static final String s_id = "s_id";
        public static final String roll_no = "roll_no";
        public static final String name = "name";
        public static final String grade = "grade";
        public static final String institute = "institute";
        public static final String gender = "gender";
        public static final String waiver = "waiver";
        public static final String father = "father";
        public static final String guardian_phn = "guardian_phn";
        public static final String bkash = "bkash";
        public static final String dropout = "dropout";
        public static final String transferred_institute = "transferred_institute";
        public static final String age = "age";
        public static final String total_bill = "total_bill";
        public static final String paid = "paid";
    }

    public static class teachers implements BaseColumns {
        public static final String table = "teachers";
        public static final String t_id = "t_id";
        public static final String name = "name";
        public static final String s_id = "s_id";
        public static final String grade = "grade";
        public static final String s_name = "s_name";
        public static final String mobile = "mobile";
        public static final String address = "address";
        public static final String total_bill = "total_bill";
        public static final String paid = "paid";
    }

    /**_________________ Admin Reporting ______________________________________*/
    /**
     * details administrative report (checklist)
     */
    public static class report_admin implements BaseColumns {

        public static final String table = "report_admin";
        public static final String sch_id = "sch_id";
        public static final String questionID = "questionID";
        public static final String questionTitle = "questionTitle";
        public static final String question = "question";
        public static final String answer = "answer";
        public static final String priority = "priority";
        public static final String details = "details";
        public static final String serverQuestion = "serverQuestion";
        public static final String answerWeight = "answerWeight";
        public static final String date_report = "date_report";
        public static final String synced = "synced";
        public static final String time_lm = "time_lm";
        public static final String notify = "notify";
        public static final String notify_his = "notify_his";
        public static final String n_update_date = "n_date_update";
    }

    public static class admin_perform implements BaseColumns {
        public static final String table = "admin_perform";
        public static final String sch_id = "sch_id";
        public static final String sch_name = "sch_name";
        public static final String adminPerformRatio = "adminPerformRatio";
        public static final String synced = "synced";
        public static final String date_report = "date_report";
        public static final String date_update = "date_update";
        public static final String time_lm = "time_lm";
        public static final String totalQues = "totalQues";
    }

    public static class admin_ques implements BaseColumns {
        public static final String table = "admin_ques";
        public static final String sch_id = "sch_id";
        public static final String quesID = "questionID";
        public static final String quesTitle = "questionTitle";
        public static final String ques = "question";
        public static final String active = "active";
        public static final String serverQuestion = "serverQuestion";
        public static final String synced = "synced";
        public static final String time_lm = "time_lm";


    }


    /*_____________________________ Evaluation Reporting _________________________________*/

    public static class report_acad implements BaseColumns {
        public static final String table = "report_acad";

        public static final String schID = "schID";
        public static final String schName = "schName";
        public static final String quesID = "quesID";
        public static final String ques = "ques";
        public static final String answer = "answer";
        public static final String active = "active";
        public static final String synced = "synced";
        public static final String server_ques = "server_ques";
        public static final String classs = "class";
        public static final String date_report = "date_report";
        public static final String date_update = "date_update";
        public static final String time_lm = "time_lm";
        public static final String totalStd = "totalStd";
        public static final String attendance = "attendance";
        public static final String attempt = "attempt";
        public static final String asked = "asked";
        public static final String correct = "correct";
        public static final String perf = "perf";


        //will not be used later
        public static final String date_asking = "date_asking";
        public static final String date_range_asking = "date_range_asking";
        public static final String total_ques = "total_ques";
    }


    /**
     * academic performance(evaluation) data will be synced(2 way) from this table
     */
    public static class acad_perform implements BaseColumns {

        public static final String table = "acad_perform";
        public static final String schoolID = "schID";
        public static final String schoolName = "schName";
        public static final String evalPerformRatio = "evalPerformRatio";
        public static final String synced = "synced";
        public static final String date_report = "date_report";
        public static final String date_update = "date_update";
        public static final String time_lm = "time_lm";
        public static final String attendence = "attendence";
        public static final String totalQues = "totalQues";     //total ques asked for a date in a schoolSync, it will be used to calculate performace avg
    }


    /**
     * evaluation questions data will be synced(1 way) from this table
     */
    public static class acad_ques implements BaseColumns {
        public static final String table = "acad_ques";

        public static final String quesID = "quesID";
        public static final String ques = "ques";
        public static final String answer = "answer";
        public static final String active = "active";
        public static final String classs = "class";
        public static final String synced = "synced";
        public static final String time_lm = "time_lm";
        public static final String server_question = "server_ques";
        public static final String date_asking = "date_asking";
        public static final String date_range_asking = "date_range_asking";
    }


    /**
     * _______________________________________________________
     */
    public static class dashboard implements BaseColumns {
        public static final String table = "dashboard";
        public static final String n_id = "n_id";
        public static final String school_id = "school_id";
        public static final String school_name = "school_name";
        public static final String attendance = "attendance";
        public static final String infrastructure = "infrastructure";
        public static final String curr_activities = "curr_activities";
        public static final String date_report = "date_report";
        public static final String time_lm = "time_lm";
    }


    public static class perform implements BaseColumns {

        public static final String table = "perform";
        public static final String sch_id = "sch_id";
        public static final String sch_name = "sch_name";
        public static final String lastAdminPerform = "lastAdminPerform";
        public static final String lastAdminPerformDate = "lastAdminPerformDate";
        public static final String lastEvalPerform = "lastEvalPerform";
        public static final String lastEvalPerformDate = "lastEvalPerformDate";
        public static final String lastAttenPerform = "lastAttenPerform";
        public static final String lastAttenPerformDate = "lastAttenPerformDate";

    }

    //============================== notification ===============================================
    public static class notif_bckup implements BaseColumns {

        public static final String table = "notif_bckup";
        public static final String sch_id = "sch_id";
        public static final String questionID = "questionID";
        public static final String questionTitle = "questionTitle";
        public static final String question = "question";
        public static final String answer = "answer";
        public static final String priority = "priority";
        public static final String details = "details";
        public static final String serverQuestion = "serverQuestion";
        public static final String answerWeight = "answerWeight";
        public static final String date_report = "date_report";
        public static final String synced = "synced";
        public static final String time_lm = "time_lm";
        public static final String notify = "notify";
        public static final String notify_his = "notify_his";
        public static final String n_update_date = "n_date_update";
    }


}

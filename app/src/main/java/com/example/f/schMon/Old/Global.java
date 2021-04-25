/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.Old;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.compat.BuildConfig;

import com.example.f.schMon.Old.analyseTemp.SQLiteDbHelper;
import com.example.f.schMon.Old.analyseTemp.SQLiteDbHelperNative;
import com.example.f.schMon.conf.model.A;

/**
 * Created by Mir Ferdous on 12/06/2017.
 */

public class Global {

/*================================= Member Variables(Global user case) =========================================================================================*/


    public static final String dbName = "conference.db";
    public static Context appContext;
    public static String packageName = BuildConfig.APPLICATION_ID;
    //_____various ids & variable for using across the app_____
    public static String user_id; //="109004";
    public static String userName;
    public static String userFullName;
    public static String userPhone;
    public static String userGrade;
    public static String userAddress;

    public static String user_role = "po";
    public static String schID;
    /**
     * this will save general settings
     */
    public static String preference = "preference";
    /**
     * strings :
     * <p>
     * "versionCode"
     * "versionName"
     * <p>
     * ________________________________________________
     */

    public static String userModel = "userModel";
    public static String userAndPass = "userAndPass";
    /**
     * ________________________________________________
     * this will save data for calculating schools performances
     */
    public static String perform = "perform";

    //______________shared preferences_________________
    /**
     * this will save responses of api call
     */


    public static String firstRun = "firstRun";
    /**
     * #======================================================================================#
     * #                                   Sync                                               #
     * #======================================================================================#
     */

    //______________DB Related_________________
    private static SQLiteDatabase sqLiteDB;
    /**
     * strings :
     * <p>
     * total_schools=no of schools under logged in user
     * counted_schools=avg performace is calculated only on those schools data of which has been inputted
     * avg_attendance
     * avg_infra
     * avg_evaluation
     * last_report_date= if current date report is not available this the report performance showed in dash(default dashboard date)
     * <p>
     * <p>
     * <p>
     * <p>
     * ________________________________________________
     */
    //public static final String dbName = "schoolMonDB2.db";
    private static int ver = 1;

    private String TAG = this.getClass().getName();


    //____________________________________ Sync__________________________________________________________________________________
    public static String synced = "1";
    public static String unsynced = "0";

    //____________________________________ Activity open mode __________________________________________________________________________________

    public static String toOpenWhichActivity = "openedWhichActivity";

    //schoolSync list
    public static String SchoolProfile = "SchoolProfile";
    public static String Reporting = "Reporting";
    public static String Evaluation = "Evaluation";


    public static String openMode = "openMode";

    //rep admin & evaluation mode selection
    public static String NewMode = "NewMode";
    public static String EditMode = "EditMode";
    public static String DisplayMode = "DisplayMode";
    public static String RunMode = "RunMode";

    //dialog
    public static String openWhat;

    public static String infoRep = "infoRep";
    public static String infoEvl = "infoEvl";

    public static String fromWhere;

    public static String LogOut = "LogOut";
    public static String StartOfApp ="StartOfApp";
/*================================= Methods =========================================================================================*/

    //________



    /**
     * #======================================================================================#
     * #                               Database                                               #
     * #======================================================================================#
     */

    //________________ get db of the app with SQLiteOpenHelper (native way)_____________________
    public static SQLiteDatabase getDB_with_nativeWay_readable(String dbName) {
        if (sqLiteDB == null)
            sqLiteDB = SQLiteDbHelperNative.getInstance(A.getAppContext(), dbName)
                    .getReadableDatabase();
        return sqLiteDB;
    }

    public static SQLiteDatabase getDB_with_nativeWay_writable(String dbName) {
        if (sqLiteDB == null)
            sqLiteDB = SQLiteDbHelperNative.getInstance(A.getAppContext(), dbName)
                    .getWritableDatabase();
        return sqLiteDB;
    }


    //________________ get db of the app with SQLiteAssetHelper Library_____________________
    public static SQLiteDatabase getDB_with_AssetHelper_readable(String dbName) {
        if (sqLiteDB == null)
            sqLiteDB = SQLiteDbHelper.getInstance(A.getAppContext(), dbName, null, ver)
                    .getReadableDatabase();
        return sqLiteDB;
    }

    public static SQLiteDatabase getDB_with_AssetHelper__writable(String dbName) {
        if (sqLiteDB == null)
            sqLiteDB = SQLiteDbHelper.getInstance(A.getAppContext(), dbName, null, ver)
                    .getWritableDatabase();
        return sqLiteDB;
    }

    /**
     * #======================================================================================#
     * #                               First Run Check                                        #
     * #======================================================================================#
     */
    public static int checkFirstRun(Context context) {
        int flag = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        //  Toast.makeText(context,String.valueOf(currentVersionCode),Toast.LENGTH_LONG).show();
        // Get saved version code
        SharedPreferences prefs = context.getSharedPreferences(Global.preference, Context.MODE_PRIVATE);
        int savedVersionCode = prefs.getInt("versionCode", -1);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            // This is just a normal run
            flag = 0;
            //return flag;

        } else if (savedVersionCode == -1) {

            // TODO This is a new install (or the user cleared the shared preferences)
            flag = 1;
        } else if (currentVersionCode > savedVersionCode) {

            // TODO This is an upgrade
            flag = 2;
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt("versionCode", currentVersionCode).commit();
        return flag;

        /**
         * new install returns 1
         * upgrade app(update version) returns 2
         * normal usual run returns 0
         * default initialized value of flag returns -1
         * */
    }


}

//+============================================================================
// $Source:  $
//
// project : Tango Device Server
//
// Description: java source code for the AoudaOBDHJava_start class and its commands.
//              This class is derived from DeviceImpl class.
//              It represents the CORBA servant obbject which
//              will be accessed from the network. All commands which
//              can be executed on the AoudaOBDHJava_start are implemented
//              in this file.
//
// $Author:  $
//
// $Revision:  $
//
// $Log:  $
//
// copyleft :   European Synchrotron Radiation Facility
//              BP 220, Grenoble 38043
//              FRANCE
//
//-============================================================================
//
//          This file is generated by POGO
//    (Program Obviously used to Generate tango Object)
//
//         (c) - Software Engineering Group - ESRF
//=============================================================================


package AoudaOBDHJava;


import java.lang.Integer;
import java.lang.System;
import java.util.*;

import org.oewf.marvin.telemetry.Sensor;
import org.oewf.marvin.telemetry.SensorName;
import org.omg.CORBA.*;
import fr.esrf.Tango.*;
import fr.esrf.TangoDs.*;
import org.oewf.marvin.telemetry.*;

//import org.oewf.aouda.telemetry.*;

/**
 *    Class Description:
 *
 *
 * @author    $Author:  $
 * @version    $Revision:  $
 */

//--------- Start of States Description ----------
/*
 *    Device States Description:
 */
//--------- End of States Description ----------
public class AoudaOBDHJava extends DeviceImpl implements TangoConst
{
    protected static String client_address = "10.123.42.1";
    protected static int client_control_port = 6668;
    protected static int client_data_port = 6669;

    //--------- Start of attributes data members ----------
    protected int state;
    protected int[] attr_AccelerationBody_read = new int[1];
    protected int[] attr_CO2_read = new int[1];
    protected int[] attr_CurrentBatteryL_read = new int[1];
    protected int[] attr_CurrentBatteryPLSS_read = new int[1];
    protected int[] attr_CurrentBatteryR_read = new int[1];
    protected int[] attr_Ecg_read = new int[1];
    protected int[] attr_GPSAltitude_read = new int[1];
    protected int[] attr_GPSLocation_read = new int[1];
    protected int[] attr_Heartrate_read = new int[1];
    protected int[] attr_HelmetHumidity_read = new int[1];
    protected int[] attr_HelmetTemp_read = new int[1];
    protected int[] attr_O2_read = new int[1];
    protected int[] attr_PressureHelmet_read = new int[1];
    protected int[] attr_SpeedFanIn1_read = new int[1];
    protected int[] attr_SpeedFanIn2_read = new int[1];
    protected int[] attr_SpeedFanOut1_read = new int[1];
    protected int[] attr_SpeedFanOut2_read = new int[1];
    protected int[] attr_TemperatureCPU_read = new int[1];
    protected int[] attr_TemperatureMainboard_read = new int[1];
    protected int[] attr_VoltageBatteryL_read = new int[1];
    protected int[] attr_VoltageBatteryPLSS_read = new int[1];
    protected int[] attr_VoltageBatteryR_read = new int[1];
    //--------- End of attributes data members ----------

    //--------- Start of properties data members ----------
    protected MarvinTelemetryClient mtc = null;
    protected MarvinDataCache mDataCache = null;
    //--------- End of properties data members ----------
//=========================================================
/**
 *    Constructor for simulated Time Device Server.
 *
 *    @param    cl The DeviceClass object
 *    @param    s The Device name.
 */
//=========================================================
    AoudaOBDHJava(DeviceClass cl, String s) throws DevFailed
    {
        super(cl,s);
        init_device();
    }
//=========================================================
/**
 *    Constructor for simulated Time Device Server.
 *
 *    @param    cl The DeviceClass object
 *    @param    s The Device name.
 *    @param    d Device description.
 */
//=========================================================
    AoudaOBDHJava(DeviceClass cl, String s, String d) throws DevFailed
    {
        super(cl,s,d);
        init_device();
    }


//=========================================================
/**
 *    Initialize the device.
 */
//=========================================================
    public void init_device() throws DevFailed
    {
        System.out.println("AoudaOBDHJava_start() create " + device_name);

        //    Initialise variables to default values
        //-------------------------------------------
        set_state(DevState.ON);
        //main proxy at msc, delayed
        //mdp = new MarvinTelemetryClient("192.168.0.1", 6668, 6669);
        //primary backup, delayed
        System.out.printf("Bounding MarvinTelemetryClient to: %s, %d, %d\n", this.client_address,
                this.client_control_port, this.client_data_port);
        mtc = new MarvinTelemetryClient(this.client_address, this.client_control_port, this.client_data_port);
        // proxy nearest to the field no delay, secondary backup
        //mdp = new MarvinTelemetryClient("192.168.1.200", 6668, 6669);
        Sensor[] sensors = new Sensor[22];
        try {
            sensors[0] = Sensor.getByName(SensorName.AccelerationBody);
            sensors[1] = Sensor.getByName(SensorName.CO2Helmet);
            sensors[2] = Sensor.getByName(SensorName.CurrentBatteryL);
            sensors[3] = Sensor.getByName(SensorName.CurrentBatteryPLSS);
            sensors[4] = Sensor.getByName(SensorName.CurrentBatteryR);
            sensors[5] = Sensor.getByName(SensorName.ECG);
            sensors[6] = Sensor.getByName(SensorName.GPSAltitude);
            sensors[7] = Sensor.getByName(SensorName.GPSLocation);
            sensors[8] = Sensor.getByName(SensorName.Heartrate);
            sensors[9] = Sensor.getByName(SensorName.HumidityHelmet);
            sensors[10] = Sensor.getByName(SensorName.O2Helmet);
            sensors[11] = Sensor.getByName(SensorName.PressureHelmet);
            sensors[12] = Sensor.getByName(SensorName.SpeedFanIn1);
            sensors[13] = Sensor.getByName(SensorName.SpeedFanIn2);
            sensors[14] = Sensor.getByName(SensorName.SpeedFanOut1);
            sensors[15] = Sensor.getByName(SensorName.SpeedFanOut2);
            sensors[16] = Sensor.getByName(SensorName.TemperatureCPU);
            sensors[17] = Sensor.getByName(SensorName.TemperatureHelmet);
            sensors[18] = Sensor.getByName(SensorName.TemperatureMainboard);
            sensors[19] = Sensor.getByName(SensorName.VoltageBatteryL);
            sensors[20] = Sensor.getByName(SensorName.VoltageBatteryPLSS);
            sensors[21] = Sensor.getByName(SensorName.VoltageBatteryR);
        }catch(UnknownSensorIdException e){
            System.out.println(e);
        }catch(InvalidSensorException e){
            System.out.println(e);
        }
        mDataCache = new MarvinDataCache(5, mtc, sensors);
        for (int i = 0; i < 22; i++) {
            System.out.print(sensors[i]);
            System.out.println(mDataCache.getNewestData(sensors[i].getId()));
            System.out.println();
        }
        System.out.println("Started Storage Daemon");
    }

//=========================================================
/**
 *    Delete the device.
 */
//=========================================================

    public void delete_device() throws DevFailed
    {
        System.out.println("AoudaOBDHJava_start() delete " + device_name);

    }


//=========================================================
/**
 *    Method always executed before command execution.
 */
//=========================================================
    public void always_executed_hook()
    {
        //get_logger().info("In always_executed_hook method()");
    }

//===================================================================
/**
 *    Method called by the read_attributes CORBA operation to
 *    read device hardware
 *
 *    @param    attr_list Vector of index in the attribute vector
 *        of attribute to be read
 */
//===================================================================
    public void read_attr_hardware(Vector attr_list) throws DevFailed
    {
        //get_logger().info("In read_attr_hardware for "+attr_list.size()+" attribute(s)");

        //    Switch on attribute name
        //---------------------------------
    }
//===================================================================
/**
 *    Method called by the read_attributes CORBA operation to
 *    set internal attribute value.
 *
 *    @param    attr reference to the Attribute object
 */
//===================================================================
    public void read_attr(Attribute attr) throws DevFailed
    {
        String attr_name = attr.get_name();
        //get_logger().info("In read_attr for attribute " + attr_name);

        //    Switch on attribute name
        //---------------------------------
        SensorData data = null;
        switch(attr_name)
        {
            case "AccelerationBody":
                data = mDataCache.getNewestData(SensorName.AccelerationBody);
                break;
            case "CO2":
                data = mDataCache.getNewestData(SensorName.CO2Helmet);
                break;
            case "CurrentBatteryL":
                data = mDataCache.getNewestData(SensorName.CurrentBatteryL);
                break;
            case "CurrentBatteryPLSS":
                data = mDataCache.getNewestData(SensorName.CurrentBatteryPLSS);
                break;
            case "CurrentBatteryR":
                data = mDataCache.getNewestData(SensorName.CurrentBatteryR);
                break;
            case "Ecg":
                data = mDataCache.getNewestData(SensorName.ECG);
                break;
            case "GPSAltitude":
                data = mDataCache.getNewestData(SensorName.GPSAltitude);
                break;
            case "GPSLocation":
                data = mDataCache.getNewestData(SensorName.GPSLocation);
                break;
            case "Heartrate":
                data = mDataCache.getNewestData(SensorName.Heartrate);
                break;
            case "HelmetHumidity":
                data = mDataCache.getNewestData(SensorName.HumidityHelmet);
                break;
            case "HelmetTemp":
                data = mDataCache.getNewestData(SensorName.TemperatureHelmet);
                break;
            case "O2":
                data = mDataCache.getNewestData(SensorName.O2Helmet);
                break;
            case "PressureHelmet":
                data = mDataCache.getNewestData(SensorName.PressureHelmet);
                break;
            case "SpeedFanIn1":
                data = mDataCache.getNewestData(SensorName.SpeedFanIn1);
                break;
            case "SpeedFanIn2":
                data = mDataCache.getNewestData(SensorName.SpeedFanIn2);
                break;
            case "SpeedFanOut1":
                data = mDataCache.getNewestData(SensorName.SpeedFanOut1);
                break;
            case "SpeedFanOut2":
                data = mDataCache.getNewestData(SensorName.SpeedFanOut2);
                break;
            case "TemperatureCPU":
                data = mDataCache.getNewestData(SensorName.TemperatureCPU);
                break;
            case "TemperatureMainboard":
                data = mDataCache.getNewestData(SensorName.TemperatureMainboard);
                break;
            case "VoltageBatteryL":
                data = mDataCache.getNewestData(SensorName.VoltageBatteryL);
                break;
            case "VoltageBatteryPLSS":
                data = mDataCache.getNewestData(SensorName.VoltageBatteryPLSS);
                break;
            case "VoltageBatteryR":
                data = mDataCache.getNewestData(SensorName.VoltageBatteryR);
                break;
            default:
                break;
        }
        attr.set_value((data != null ? data.getDataAsIntegers()[0] : 0));
    }



//=========================================================
/**
 *    main part for the device server class
 */
//=========================================================
    public static void main(String[] argv)
    {
        try
        {
            // read and set up command line options
            int host_str_index = Arrays.asList(argv).indexOf("--host");
            int control_port_str_index = Arrays.asList(argv).indexOf("--control");
            int data_port_str_index = Arrays.asList(argv).indexOf("--data");
            if (host_str_index >= 0){
                AoudaOBDHJava.client_address = argv[host_str_index + 1];
            }
            if (control_port_str_index >= 0){
                try {
                    AoudaOBDHJava.client_control_port = Integer.parseInt(argv[control_port_str_index + 1]);
                }catch (NumberFormatException e){
                    System.err.println("Control port is not an integer");
                    System.err.println("Exiting");
                    System.exit(-1);
                }
            }
            if (data_port_str_index >= 0){
                try {
                    AoudaOBDHJava.client_data_port = Integer.parseInt(argv[data_port_str_index + 1]);
                }catch (NumberFormatException e){
                    System.err.println("Control port is not an integer");
                    System.err.println("Exiting");
                    System.exit(-1);
                }
            }
            Util tg = Util.init(argv, "AoudaOBDHJava_start");
            tg.server_init();

            System.out.println("Ready to accept request");

            tg.server_run();
        }

        catch (OutOfMemoryError ex)
        {
            System.err.println("Can't allocate memory !!!!");
            System.err.println("Exiting");
        }
        catch (UserException ex)
        {
            Except.print_exception(ex);

            System.err.println("Received a CORBA user exception");
            System.err.println("Exiting");
        }
        catch (SystemException ex)
        {
            Except.print_exception(ex);

            System.err.println("Received a CORBA system exception");
            System.err.println("Exiting");
        }

        System.exit(-1);
    }
}


//--------------------------------------------------------------------------
/* end of $Source: /cvsroot/tango-cs/tango/tools/pogo/templates/java/DevServ.java,v $ */

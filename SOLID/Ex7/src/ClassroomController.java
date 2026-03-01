public class ClassroomController implements ClassroomControllerInterface {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    @Override
    public void startClass() {
        
        SmartClassroomDevice pjDevice = reg.getFirstOfType("Projector");
        pjDevice.powerOn();
        ((ProjectorInterface) pjDevice).connectInput("HDMI-1");


        ((LightPanelInterface) reg.getFirstOfType("LightsPanel")).setBrightness(60);


        ((AirConditionerInterface) reg.getFirstOfType("AirConditioner")).setTemperatureC(24);

        System.out.println("Attendance scanned: present=" +
            ((AttendanceScannerInterface) reg.getFirstOfType("AttendanceScanner")).scanAttendance());
    }

    @Override
    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstOfType("Projector").powerOff();
        reg.getFirstOfType("LightsPanel").powerOff();
        reg.getFirstOfType("AirConditioner").powerOff();
    }
}
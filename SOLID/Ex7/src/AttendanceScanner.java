public class AttendanceScanner implements SmartClassroomDevice, AttendanceScannerInterface {
    @Override public void powerOn()  { /* ok */ }
    @Override public void powerOff() { /* silent — not in shutdown sequence */ }

    @Override public int scanAttendance() { return 3; }
}

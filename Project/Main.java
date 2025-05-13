//Özlem Nur Nazlıoğlu 20210601043
//Murat Vermez 20200601057
//Murat Göçmen 20210601026
//Mehmet Kağan Kaça 20200601030
package Project;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 🚜 Livestock Farm Management System ===");

        // FACTORY
        CattleFactory dairyFactory = new DairyCattleFactory();
        CattleFactory beefFactory = new BeefCattleFactory();
        Cattle dairy = dairyFactory.createCattle("D001");
        Cattle beef = beefFactory.createCattle("B001");

        dairy.feed();
        beef.feed();

        // SINGLETON
        FarmDatabase db = FarmDatabase.getInstance();
        db.updateLocation(dairy.getId(), 45);  // Inside the farm
        db.updateLocation(beef.getId(), 110);  // Outside the farm

        // OBSERVER
        LocationTracker tracker = new LocationTracker();
        Farmer farmer = new Farmer("John");
        tracker.registerObserver(farmer);
        tracker.checkLocation(dairy.getId(), 45);    // No alert
        tracker.checkLocation(beef.getId(), 110);    // Triggers alert

        // COMMAND
        OperationScheduler scheduler = new OperationScheduler();
        scheduler.scheduleOperation(new VaccinationCommand(), dairy);
        scheduler.scheduleOperation(new InspectionCommand(), beef);

        // ADAPTER
        BluetoothDevice btDevice = new BluetoothDevice();
        ZigbeeSender adapter = new BluetoothToZigbeeAdapter(btDevice);
        adapter.send("BT001", 120);  // Example use with String type for Bluetooth

        System.out.println("=== ✅ System Execution Complete ===");
    }
}

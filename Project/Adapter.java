package Project;

// Sends data using Bluetooth
class BluetoothDevice {
    public void sendViaBluetooth(String cattleId, int distanceToFarm) {
        System.out.println("[Bluetooth] Sent data: " + cattleId + " at distance " + distanceToFarm + " meters.");
    }
}

// Target interface (Zigbee)
interface ZigbeeSender {
    void send(String cattleId, Integer distanceToFarm);
}

// Adapter to make Bluetooth work like Zigbee
class BluetoothToZigbeeAdapter implements ZigbeeSender {
    private BluetoothDevice bluetoothDevice;

    public BluetoothToZigbeeAdapter(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    // Converts Zigbee send to Bluetooth send
    @Override
    public void send(String cattleId, Integer distanceToFarm) {
        bluetoothDevice.sendViaBluetooth(cattleId, distanceToFarm);
    }
}

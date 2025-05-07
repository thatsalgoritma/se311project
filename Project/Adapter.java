package Project;


class BluetoothDevice {
    public void sendViaBluetooth(String cattleId, int distanceToFarm) {
        System.out.println("[Bluetooth] Sent data: " + cattleId + " at distance " + distanceToFarm + " meters.");
    }
}
interface ZigbeeSender {
    void send(String cattleId, Integer distanceToFarm);
}
class BluetoothToZigbeeAdapter implements ZigbeeSender {
    private BluetoothDevice bluetoothDevice;

    public BluetoothToZigbeeAdapter(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    @Override
    public void send(String cattleId, Integer distanceToFarm) {
        // Convert to the format the server accepts by relaying through Bluetooth device
        bluetoothDevice.sendViaBluetooth(cattleId, distanceToFarm);
    }
}
package Project;

interface Command {
    void execute(Cattle cattle);  // The command will act on a Cattle object
}

// Concrete command class to vaccinate cattle
class VaccinationCommand implements Command {

    @Override
    public void execute(Cattle cattle) {
        // When executed the cattle will be marked as vaccinated
        System.out.println("💉 Cattle " + cattle.getId() + " vaccinated against seasonal diseases.");
        cattle.hasVaccinated = true;
    }
}

// Concrete command class to inspect cattle
class InspectionCommand implements Command {

    @Override
    public void execute(Cattle cattle) {
        // When executed checks if the cattle has been vaccinated
        System.out.println("🧾 Cattle " + cattle.getId() + " inspected for plastic ear tag and ID.");
        if (!cattle.hasVaccinated) {
            System.out.println("Cattle " + cattle.getId() + " is not vaccinated.");
        } else {
            System.out.println("Cattle " + cattle.getId() + " is vaccinated.");
        }
    }
}

//This class schedules and runs the operations for commands
class OperationScheduler {

    // Method to execute commands on a directly to given cattle
    public void scheduleOperation(Command command, Cattle cattle) {
        command.execute(cattle);
    }
}

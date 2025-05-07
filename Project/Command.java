package Project;

interface Command {
    void execute(Cattle cattle);
}
class VaccinationCommand implements Command {

    @Override
    public void execute(Cattle cattle) {
        System.out.println("💉 Cattle " + cattle.getId() + " vaccinated against seasonal diseases.");
        cattle.hasVaccinated = true;
    }
}
class InspectionCommand implements Command {

    @Override
    public void execute(Cattle cattle) {
        System.out.println("🧾 Cattle " + cattle.getId() + " inspected for plastic ear tag and ID.");
        if (!cattle.hasVaccinated) {
            System.out.println("Cattle " + cattle.getId() + " is not vaccinated.");
        }else {
            System.out.println("Cattle " + cattle.getId() + " is vaccinated.");
        }
    }
}
class OperationScheduler {

    public void scheduleOperation(Command command, Cattle cattle) {
        command.execute(cattle);
    }
}
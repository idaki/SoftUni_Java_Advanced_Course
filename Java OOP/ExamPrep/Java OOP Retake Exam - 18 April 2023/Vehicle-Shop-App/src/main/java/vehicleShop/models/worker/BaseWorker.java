package vehicleShop.models.worker;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;
import vehicleShop.utils.IntegerUtils;
import vehicleShop.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public abstract class BaseWorker implements Worker {


    private String name;
    private int strength;
    private Collection<Tool> tools;

    protected BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    protected void setName(String name) {
        if (StringUtils.isNullOrEmptyString(name)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(int strength) {
        if (IntegerUtils.isNegativeNumber(strength)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public abstract void working();

    @Override
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    @Override
    public boolean canWork() {

        return this.strength > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }

    @Override
    public String toString() {
       String pattern = ConstantMessages.NAME
            + ConstantMessages.STRENGTH
            + System.lineSeparator()
               + ConstantMessages.TOOLS;

       int countTools = (int) this.tools.stream().filter(t -> !t.isUnfit()).count();

        String printWorker = String.format(pattern,this.name,this.strength, countTools);
        return printWorker;
    }
}

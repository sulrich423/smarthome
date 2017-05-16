package smarthome;

public abstract class AbstractAction {

  public abstract Action getOnAction();

  public abstract Action getOffAction();

  public Action getSetPercentageAction(double value) {
    throw new UnsupportedOperationException();
  }

}

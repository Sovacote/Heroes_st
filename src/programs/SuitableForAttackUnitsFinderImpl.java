package programs;

import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.SuitableForAttackUnitsFinder;

import java.util.List;
import java.util.ArrayList;



public class SuitableForAttackUnitsFinderImpl implements SuitableForAttackUnitsFinder {

    private int availablePoints; // Поле для хранения доступных очков

    // Конструктор по умолчанию
    public SuitableForAttackUnitsFinderImpl() {
        this.availablePoints = 0; // Значение по умолчанию
    }

    // Конструктор для инициализации доступных очков
    public SuitableForAttackUnitsFinderImpl(int availablePoints) {
        this.availablePoints = availablePoints;
    }

    @Override
    public List<Unit> getSuitableUnits(List<List<Unit>> unitsByRow, boolean isLeftArmyTarget) {
        List<Unit> suitableUnits = new ArrayList<>();

        // Перебираем каждый ряд юнитов
        for (List<Unit> row : unitsByRow) {
            for (Unit unit : row) {
                // Проверяем, что юнит живой и его стоимость не превышает доступные очки
                if (unit.isAlive() && unit.getCost() <= availablePoints) {
                    // Добавляем юнит в список подходящих, если он принадлежит нужной армии
                    if ((isLeftArmyTarget && unit.getxCoordinate() < 0) ||
                            (!isLeftArmyTarget && unit.getxCoordinate() >= 0)) {
                        suitableUnits.add(unit);
                    }
                }
            }
        }

        return suitableUnits; // Возвращаем список подходящих юнитов
    }
}

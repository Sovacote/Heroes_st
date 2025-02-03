package programs;

import com.battle.heroes.army.Army;
import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.GeneratePreset;

import java.util.*;

public class GeneratePresetImpl implements GeneratePreset {

    @Override
    public Army generate(List<Unit> unitList, int maxPoints) {
        //Сложность: O(n log n)
        // Сортируем юниты по стоимости (по возрастанию)
        Collections.sort(unitList, Comparator.comparingInt(Unit::getCost));

        Army army = new Army();
        int totalPoints = 0;

        // Перебираем отсортированные юниты
        for (Unit unit : unitList) {
            // Проверяем, можем ли мы добавить юнит в армию, не превышая лимит очков
            while (totalPoints + unit.getCost() <= maxPoints) {
                army.getUnits().add(unit); // Добавляем юнит в армию
                totalPoints += unit.getCost(); // Обновляем общее количество очков
            }
        }

        army.setPoints(totalPoints); // Устанавливаем общее количество очков в армии
        return army; // Возвращаем сформированную армию
    }
}




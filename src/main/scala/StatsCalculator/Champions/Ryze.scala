package StatsCalculator.Champions

import StatsCalculator.BaseStats
import StatsCalculator.Items.{Item, SeraphsEmbrace}

class Ryze
(
  level: Int,
  items: List[Item],
  baseStats: BaseStats = new BaseStats(
    570.48,
    98,
    400,
    50),
)
  extends Champion(level, items, baseStats) {

  if (items.collectFirst { case i: SeraphsEmbrace => i }.isDefined) {
    
    setTotalStats()
    
    val apWithSeraphs = (_bonusAbilityPower * _abilityPowerMultiplier + 0.03 * _totalMana * _abilityPowerMultiplier) / (1 - 0.000015 * _totalMana * _abilityPowerMultiplier)
    // Turns out second formula from http://leagueoflegends.wikia.com/wiki/Ryze sucks balls

    _totalAbilityPower = apWithSeraphs
    _bonusMana += (_baseMana + _bonusMana) * (_totalAbilityPower / 100 * 0.05)
    
    _totalMana = _baseMana + _bonusMana
  }
  else {
    
    _bonusMana += (_baseMana + _bonusMana) * (_totalAbilityPower / 100 * 0.05)
    
    setTotalStats()
  }

  def qDamage: (Double, Double, Double) = {
    (185, abilityPower * 0.45, _bonusMana * 0.03)
  }

  def wDamage: (Double, Double, Double) = {
    (160, abilityPower * 0.6, _bonusMana * 0.01)
  }

  def eDamage: (Double, Double, Double) = {
    (150, abilityPower * 0.3, _bonusMana * 0.02)
  }

  override def toString: String = {
    val formatDamage = (t: (Double, Double, Double)) => {
      
      s"${t._1 + t._2 + t._3} = ${t._1} (+${t._2}) (+${t._3})"
      
    }

    val stringBuilder = new StringBuilder();
    stringBuilder.append(s"\nQ: ${formatDamage(qDamage)}");
    stringBuilder.append(s"\nW: ${formatDamage(wDamage)}");
    stringBuilder.append(s"\nE: ${formatDamage(eDamage)}");
    super.toString + stringBuilder.toString()
  }
}


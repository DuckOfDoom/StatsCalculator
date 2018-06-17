package StatsCalculator.Champions

import StatsCalculator.BaseStats
import StatsCalculator.Items.Item

class Champion( level: Int, items: List[Item] = Nil, baseStats: BaseStats = new BaseStats()) {
  
  def health: Double = _totalHealth
  def mana: Double = _totalMana
  def abilityPower: Double = _totalAbilityPower

  protected var _baseHealth: Double = baseStats.baseHealth
  protected var _bonusHealth: Double = 0
  
  protected var _baseMana: Double = baseStats.baseMana
  protected var _bonusMana: Double = 0
  
  protected var _bonusAbilityPower: Double = 0
  protected var _abilityPowerMultiplier: Double = 1
  
  protected var _totalAbilityPower : Double = 0
  protected var _totalMana : Double = 0
  protected var _totalHealth : Double = 0
  
  //  Apply per level growth
  (1 until level).foreach(_ => {
    _baseHealth += baseStats.healthPerLevel
    _baseMana += baseStats.manaPerLevel
  })

  // Apply items
  items.foreach(i => {
    _bonusHealth += i.health
    _bonusMana += i.mana
    _bonusAbilityPower += i.abilityPower
    _abilityPowerMultiplier += i.abilityPowerMultiplier
  })
  
  protected def setTotalStats(): Unit = {
    _totalAbilityPower = _bonusAbilityPower * _abilityPowerMultiplier
    _totalHealth = _baseHealth + _bonusHealth
    _totalMana = _baseMana + _bonusMana
  }
  
  setTotalStats()
  
  override def toString: String = {
    s"Health: $health\nMana: $mana\nAp: $abilityPower"
  }
}


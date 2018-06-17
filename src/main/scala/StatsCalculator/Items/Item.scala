package StatsCalculator.Items

class Item (
  val health : Double = 0,
  val mana : Double = 0,
  val abilityPower : Double = 0,
  val abilityPowerMultiplier : Double = 0
)

class SapphireCrystal() extends Item(mana = 250)
class CatalystOfAeons() extends Item(health = 225, mana = 300)
class RodOfAges() extends Item(health = 500, mana = 400, abilityPower = 100)
class NeedlesslyLargeRod() extends Item(abilityPower = 60)
class RabadonsDeathcap() extends Item(abilityPower = 120, abilityPowerMultiplier = 0.4)
class TearOfGoddess() extends Item(mana = 1000)
class ArchangelsStaff() extends Item(mana = 650, abilityPower = 50)
class SeraphsEmbrace() extends Item(mana = 1400, abilityPower = 50)
class LudensEcho() extends Item(abilityPower = 600)
class FrozenHeart() extends Item(mana =  400)
class IcebornGauntlet extends Item(mana = 500)
class Lichbane() extends Item(mana = 250, abilityPower = 80)

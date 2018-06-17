import StatsCalculator.BaseStats
import StatsCalculator.Champions.{Champion, Ryze}
import StatsCalculator.Items.{Item, RabadonsDeathcap, SapphireCrystal, SeraphsEmbrace}
import org.scalatest.FunSuite

class ChampionTest extends FunSuite {

  test("Champion. Per level calculation.") {
    val champion = new Champion(
      10,
      baseStats = new BaseStats(
        1,
        1,
        5,
        5
      )
    )


    assertResult(10)(champion.health)
    assertResult(50)(champion.mana)
  }

  test("Champion. Calculation with items.") {

    class TestItem1 extends Item(health = 15, mana = 50, abilityPower = 10)
    class TestItem2 extends Item(health = 30, mana = 10, abilityPower = 0, abilityPowerMultiplier = 0.5)

    val champion = new Champion(
      1,
      List[Item](
        new TestItem1,
        new TestItem2
      )
    )

    assertResult(45)(champion.health)
    assertResult(60)(champion.mana)
    assertResult(15)(champion.abilityPower)
  }


  test("Champion. Ryze calculation without seraphs") {
    val ryze = new Ryze(
      18
      , List[Item](
        new SapphireCrystal(),
        new RabadonsDeathcap()
      )
    )

    assertResult(168)(ryze.abilityPower)
    assertResult(1626)(ryze.mana)
  }

  test(testName = "Champion. Ryze calculation with seraphs.") {
    val ryze = new Ryze(
      18
      , List[Item](
        new SapphireCrystal(),
        new RabadonsDeathcap(),
        new SeraphsEmbrace()
      )
    )

    assertResult(383)(ryze.abilityPower.toInt)
    assertResult(3455)(ryze.mana.toInt)
  }
}

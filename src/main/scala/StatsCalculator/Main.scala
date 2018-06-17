package StatsCalculator

import StatsCalculator.Champions.Ryze
import StatsCalculator.Items._

object Main {

  def main(args: Array[String]): Unit = {

    val ryze = new Ryze(
      18
      , List[Item](
        new SapphireCrystal(),
        new RabadonsDeathcap(),
        new SeraphsEmbrace()
      )

    )

    println(ryze);
  }
}


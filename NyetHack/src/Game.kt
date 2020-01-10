import sun.jvm.hotspot.code.NMethod

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)


    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireBall()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun castFireBall(numFireballs: Int = 2) =
    println("A glass of FireBall springs into existence (x$numFireballs)")


private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean)  =
    when (healthPoints) {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches"
        in 75..89 -> if (isBlessed) {
            " has some minor woulds but is healing quite quickly"
        } else {
            " has a some minor wounds"
        }
        in 15..74 -> " looks pretty hurt"
        else -> " is in awful condition!"
    }

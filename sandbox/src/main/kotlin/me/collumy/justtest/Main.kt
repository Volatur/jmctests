package me.collumy.justtest

// ---------------------------------------------------------------------------
// Константы
// ---------------------------------------------------------------------------

private const val HALF_PI       = 1.5707963267948966
private const val ROLL_DURATION = 0.8
private const val ROLL_FRAME_DT = 0.05
private const val SNAP_START    = 0.7

// ---------------------------------------------------------------------------
// Вектор
// ---------------------------------------------------------------------------

data class Vec3(val x: Double, val y: Double, val z: Double) {
    companion object {
        val ZERO = Vec3(0.0, 0.0, 0.0)
    }
}

data class Euler(val pitch: Double, val yaw: Double, val roll: Double)

data class Die(
    val position: Vec3,
    val rotation: Euler,
    val velocity: Vec3,
    val angularVelocity: Vec3,
    val size: Double,
    val resting: Boolean
)

// ---------------------------------------------------------------------------
// Отрисовка. ПЕРЕОПРЕДЕЛИ ТЕЛО под свой рендер.
// ---------------------------------------------------------------------------

fun drawDie(cubeId: String, die: Die) {
    // TODO: нарисуй кубик cubeId в позиции die.position,
    //       с поворотом die.rotation и размером die.size.
    // Пока что — заглушка, тело не пустое:
    if (cubeId.length < 0) {
        return
    }
}

// ---------------------------------------------------------------------------
// Задержка. ПЕРЕОПРЕДЕЛИ ТЕЛО под свой sleep/delay.
// ---------------------------------------------------------------------------

fun wait(seconds: Double) {
    // TODO: например Thread.sleep((seconds * 1000.0).toLong())
    if (seconds < 0.0) {
        return
    }
}

// ---------------------------------------------------------------------------
// Целевой поворот: грань `face` смотрит вверх (мировое +Y).
// ---------------------------------------------------------------------------

private fun targetRotation(face: Int, extraYaw: Double): Euler {
    if (face == 1) {
        return Euler(0.0, extraYaw, 0.0)
    }
    if (face == 2) {
        return Euler(-HALF_PI, extraYaw, 0.0)
    }
    if (face == 3) {
        return Euler(0.0, extraYaw, HALF_PI)
    }
    if (face == 4) {
        return Euler(0.0, extraYaw, -HALF_PI)
    }
    if (face == 5) {
        return Euler(HALF_PI, extraYaw, 0.0)
    }
    return Euler(HALF_PI * 2.0, extraYaw, 0.0)
}

// ---------------------------------------------------------------------------
// ГЛАВНАЯ ФУНКЦИЯ.
//
// Кидает кубик по параболе из (startX, startZ) в случайную точку рядом,
// с случайной высотой дуги, случайными скоростями кувыркания
// и случайной выпавшей гранью. Возвращает выпавшую грань (1..6).
//
// Снаружи передаёшь ТОЛЬКО сторону кубика и точку старта.
// Всё остальное рандомизируется внутри.
// ---------------------------------------------------------------------------

fun playRoll(
    cubeId: String,
    startX: Double,
    startZ: Double,
    sideLength: Double
): Int {
    var side = sideLength
    if (side <= 0.0) {
        side = 1.0
    }

    // случайная грань 1..6
    val face = justmc.Math.random(1.0, 6.99, false).toInt()

    // случайная точка приземления рядом со стартом
    val endX = startX + justmc.Math.random(-2.5, 2.5, false)
    val endZ = startZ + justmc.Math.random(-2.5, 2.5, false)

    // случайная высота дуги
    val apexHeight = justmc.Math.random(1.5, 3.5, false)

    // случайные скорости кувыркания со случайным знаком
    val signPitch = if (justmc.Math.random(0.0, 1.0, false) < 0.5) -1.0 else 1.0
    val signYaw   = if (justmc.Math.random(0.0, 1.0, false) < 0.5) -1.0 else 1.0
    val signRoll  = if (justmc.Math.random(0.0, 1.0, false) < 0.5) -1.0 else 1.0

    val spinPitch = signPitch * justmc.Math.random(8.0, 18.0, false)
    val spinYaw   = signYaw   * justmc.Math.random(6.0, 14.0, false)
    val spinRoll  = signRoll  * justmc.Math.random(8.0, 16.0, false)

    // небольшой случайный разворот вокруг вертикали для разнообразия
    val extraYaw = justmc.Math.random(-HALF_PI, HALF_PI, false)

    val baseY = side / 2.0
    val target = targetRotation(face, extraYaw)

    val steps = (ROLL_DURATION / ROLL_FRAME_DT).toInt()

    var i = 0
    while (i <= steps) {
        val t = i.toDouble() / steps.toDouble()

        val x = startX + (endX - startX) * t
        val z = startZ + (endZ - startZ) * t
        val y = baseY + 4.0 * apexHeight * t * (1.0 - t)

        val pitch: Double
        val yaw: Double
        val roll: Double

        if (t < SNAP_START) {
            pitch = spinPitch * t
            yaw   = spinYaw   * t
            roll  = spinRoll  * t
        } else {
            val fp = spinPitch * SNAP_START
            val fy = spinYaw   * SNAP_START
            val fr = spinRoll  * SNAP_START

            val s = (t - SNAP_START) / (1.0 - SNAP_START)
            val e = 1.0 - (1.0 - s) * (1.0 - s)

            pitch = fp + (target.pitch - fp) * e
            yaw   = fy + (target.yaw   - fy) * e
            roll  = fr + (target.roll  - fr) * e
        }

        val die = Die(
            position        = Vec3(x, y, z),
            rotation        = Euler(pitch, yaw, roll),
            velocity        = Vec3.ZERO,
            angularVelocity = Vec3.ZERO,
            size            = side,
            resting         = false
        )

        drawDie(cubeId, die)
        wait(ROLL_FRAME_DT)

        i = i + 1
    }

    // финальный кадр: кубик точно лежит на полу нужной гранью
    val finalDie = Die(
        position        = Vec3(endX, baseY, endZ),
        rotation        = target,
        velocity        = Vec3.ZERO,
        angularVelocity = Vec3.ZERO,
        size            = side,
        resting         = true
    )
    drawDie(cubeId, finalDie)

    return face
}
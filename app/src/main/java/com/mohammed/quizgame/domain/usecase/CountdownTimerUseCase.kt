package com.mohammed.quizgame.domain.usecase

import android.os.CountDownTimer
import javax.inject.Inject

class CountdownTimerUseCase @Inject constructor(){
    private var countdownTimer: CountDownTimer? = null

    fun startTimer(
        totalTime: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit,
        interval:Long
    ) {

        countdownTimer = object : CountDownTimer(totalTime, interval) {

            override fun onTick(millisUntilFinished: Long) {
                onTick(millisUntilFinished / interval)
            }

            override fun onFinish() {
                onFinish()
            }
        }
        countdownTimer?.start()
    }

    fun stopTimer() {
        countdownTimer?.cancel()
        countdownTimer = null
    }


}
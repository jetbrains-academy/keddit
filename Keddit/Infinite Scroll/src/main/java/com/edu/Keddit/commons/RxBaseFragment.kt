package com.edu.keddit.commons


import androidx.fragment.app.Fragment
import rx.subscriptions.CompositeSubscription

open class RxBaseFragment : androidx.fragment.app.Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}
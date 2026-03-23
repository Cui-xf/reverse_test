package androidx.compose.ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: FocusTransactionManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J4\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\b¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\b¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u0004\u0018\u00010\f*\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/focus/FocusTransactionManager;", "", "()V", "cancellationListener", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "", "ongoingTransaction", "", "states", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "uncommittedFocusState", "getUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusStateImpl;", "setUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusStateImpl;)V", "beginTransaction", "cancelTransaction", "commitTransaction", "withExistingTransaction", "T", "onCancelled", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNewTransaction", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionManager {
    public static final int $stable = 8;
    private boolean ongoingTransaction;
    private final MutableScatterMap<FocusTargetNode, FocusStateImpl> states = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector<Function0<Unit>> cancellationListener = new MutableVector<>(new Function0[16], 0);

    public static /* synthetic */ Object withNewTransaction$default(FocusTransactionManager $this, Function0 onCancelled, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            onCancelled = null;
        }
        try {
            if ($this.ongoingTransaction) {
                $this.cancelTransaction();
            }
            $this.beginTransaction();
            if (onCancelled != null) {
                Function0 it = onCancelled;
                MutableVector this_$iv = $this.cancellationListener;
                this_$iv.add(it);
            }
            return block.invoke();
        } finally {
            $this.commitTransaction();
        }
    }

    public final <T> T withNewTransaction(Function0<Unit> onCancelled, Function0<? extends T> block) {
        try {
            if (this.ongoingTransaction) {
                cancelTransaction();
            }
            beginTransaction();
            if (onCancelled != null) {
                MutableVector this_$iv = this.cancellationListener;
                this_$iv.add(onCancelled);
            }
            return block.invoke();
        } finally {
            commitTransaction();
        }
    }

    public static /* synthetic */ Object withExistingTransaction$default(FocusTransactionManager $this, Function0 onCancelled, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            onCancelled = null;
        }
        if (onCancelled != null) {
            Function0 it = onCancelled;
            MutableVector this_$iv = $this.cancellationListener;
            this_$iv.add(it);
        }
        if ($this.ongoingTransaction) {
            return block.invoke();
        }
        try {
            $this.beginTransaction();
            return block.invoke();
        } finally {
            $this.commitTransaction();
        }
    }

    public final <T> T withExistingTransaction(Function0<Unit> onCancelled, Function0<? extends T> block) {
        if (onCancelled != null) {
            MutableVector this_$iv = this.cancellationListener;
            this_$iv.add(onCancelled);
        }
        if (this.ongoingTransaction) {
            return block.invoke();
        }
        try {
            beginTransaction();
            return block.invoke();
        } finally {
            commitTransaction();
        }
    }

    public final FocusStateImpl getUncommittedFocusState(FocusTargetNode $this$uncommittedFocusState) {
        return this.states.get($this$uncommittedFocusState);
    }

    public final void setUncommittedFocusState(FocusTargetNode $this$uncommittedFocusState, FocusStateImpl value) {
        MutableScatterMap<FocusTargetNode, FocusStateImpl> mutableScatterMap = this.states;
        if (value != null) {
            mutableScatterMap.set($this$uncommittedFocusState, value);
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void commitTransaction() {
        /*
            r21 = this;
            r0 = r21
            androidx.collection.MutableScatterMap<androidx.compose.ui.focus.FocusTargetNode, androidx.compose.ui.focus.FocusStateImpl> r1 = r0.states
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            r2 = 0
            java.lang.Object[] r3 = r1.keys
            r4 = r1
            r5 = 0
            long[] r6 = r4.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            r8 = 0
            if (r8 > r7) goto L64
        L13:
            r10 = r6[r8]
            r12 = r10
            r14 = 0
            r16 = r10
            long r9 = ~r12
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r12
            r18 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r18
            int r11 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r11 == 0) goto L5f
            int r9 = r8 - r7
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L32:
            if (r11 >= r9) goto L5d
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r16 & r12
            r14 = 0
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r20 >= 0) goto L42
            r18 = 1
            goto L44
        L42:
            r18 = 0
        L44:
            if (r18 == 0) goto L58
            int r12 = r8 << 3
            int r12 = r12 + r11
            r13 = r12
            r14 = 0
            r18 = r3[r13]
            androidx.compose.ui.focus.FocusTargetNode r18 = (androidx.compose.ui.focus.FocusTargetNode) r18
            r19 = 0
            r18.commitFocusState$ui_release()
        L58:
            long r16 = r16 >> r10
            int r11 = r11 + 1
            goto L32
        L5d:
            if (r9 != r10) goto L65
        L5f:
            if (r8 == r7) goto L64
            int r8 = r8 + 1
            goto L13
        L64:
        L65:
            androidx.collection.MutableScatterMap<androidx.compose.ui.focus.FocusTargetNode, androidx.compose.ui.focus.FocusStateImpl> r1 = r0.states
            r1.clear()
            r15 = 0
            r0.ongoingTransaction = r15
            androidx.compose.runtime.collection.MutableVector<kotlin.jvm.functions.Function0<kotlin.Unit>> r1 = r0.cancellationListener
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionManager.commitTransaction():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTransaction() {
        this.states.clear();
        this.ongoingTransaction = false;
        MutableVector this_$iv = this.cancellationListener;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                Function0 it = (Function0) content$iv[i$iv];
                it.invoke();
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.cancellationListener.clear();
    }
}

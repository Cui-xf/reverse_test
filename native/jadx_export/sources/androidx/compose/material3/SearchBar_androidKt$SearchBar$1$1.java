package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1", f = "SearchBar.android.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class SearchBar_androidKt$SearchBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$1$1(Animatable<Float, AnimationVector1D> animatable, boolean z, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, Continuation<? super SearchBar_androidKt$SearchBar$1$1> continuation) {
        super(2, continuation);
        this.$animationProgress = animatable;
        this.$expanded = z;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState;
        this.$currentBackEvent = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBar_androidKt$SearchBar$1$1(this.$animationProgress, this.$expanded, this.$finalBackProgress, this.$firstBackEvent, this.$currentBackEvent, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBar_androidKt$SearchBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            switch(r2) {
                case 0: goto L1c;
                case 1: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L13:
            r0 = r18
            r2 = r19
            kotlin.ResultKt.throwOnFailure(r2)
            goto L97
        L1c:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r3 = r19
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r2.$animationProgress
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r7 = 0
            r8 = 1
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L4a
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r2.$animationProgress
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L4a
            r4 = 1
            goto L4b
        L4a:
            r4 = 0
        L4b:
            if (r4 == 0) goto L52
            androidx.compose.animation.core.FiniteAnimationSpec r9 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationPredictiveBackExitFloatSpec$p()
            goto L5f
        L52:
            boolean r4 = r2.$expanded
            if (r4 == 0) goto L5b
            androidx.compose.animation.core.FiniteAnimationSpec r9 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationEnterFloatSpec$p()
            goto L5f
        L5b:
            androidx.compose.animation.core.FiniteAnimationSpec r9 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationExitFloatSpec$p()
        L5f:
            boolean r4 = r2.$expanded
            if (r4 == 0) goto L66
            goto L67
        L66:
            r5 = 0
        L67:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r2.$animationProgress
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L78
            r6 = 1
        L78:
            if (r6 != 0) goto L99
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r10 = r2.$animationProgress
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r12 = r9
            androidx.compose.animation.core.AnimationSpec r12 = (androidx.compose.animation.core.AnimationSpec) r12
            r15 = r2
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r2.label = r8
            r13 = 0
            r14 = 0
            r16 = 12
            r17 = 0
            java.lang.Object r4 = androidx.compose.animation.core.Animatable.animateTo$default(r10, r11, r12, r13, r14, r15, r16, r17)
            if (r4 != r0) goto L95
            return r0
        L95:
            r0 = r2
            r2 = r3
        L97:
            r3 = r2
            r2 = r0
        L99:
            boolean r0 = r2.$expanded
            if (r0 != 0) goto Laf
            androidx.compose.runtime.MutableFloatState r0 = r2.$finalBackProgress
            r4 = 2143289344(0x7fc00000, float:NaN)
            r0.setFloatValue(r4)
            androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r0 = r2.$firstBackEvent
            r4 = 0
            r0.setValue(r4)
            androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r0 = r2.$currentBackEvent
            r0.setValue(r4)
        Laf:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

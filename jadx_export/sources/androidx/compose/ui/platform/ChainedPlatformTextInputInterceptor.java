package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: PlatformTextInputModifierNode.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005J?\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\b\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0003R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "", "initialInterceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "parent", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;)V", "<set-?>", "interceptor", "getInterceptor", "()Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "setInterceptor", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;)V", "interceptor$delegate", "Landroidx/compose/runtime/MutableState;", "textInputSession", "", "owner", "Landroidx/compose/ui/node/Owner;", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/node/Owner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInterceptor", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ChainedPlatformTextInputInterceptor {

    /* renamed from: interceptor$delegate, reason: from kotlin metadata */
    private final MutableState interceptor;
    private final ChainedPlatformTextInputInterceptor parent;

    /* compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor", f = "PlatformTextInputModifierNode.kt", i = {}, l = {229}, m = "textInputSession", n = {}, s = {})
    /* renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChainedPlatformTextInputInterceptor.this.textInputSession(null, null, this);
        }
    }

    public ChainedPlatformTextInputInterceptor(PlatformTextInputInterceptor initialInterceptor, ChainedPlatformTextInputInterceptor parent) {
        this.parent = parent;
        this.interceptor = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialInterceptor, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlatformTextInputInterceptor getInterceptor() {
        State $this$getValue$iv = this.interceptor;
        return (PlatformTextInputInterceptor) $this$getValue$iv.getValue();
    }

    private final void setInterceptor(PlatformTextInputInterceptor platformTextInputInterceptor) {
        MutableState $this$setValue$iv = this.interceptor;
        $this$setValue$iv.setValue(platformTextInputInterceptor);
    }

    public final void updateInterceptor(PlatformTextInputInterceptor interceptor) {
        setInterceptor(interceptor);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object textInputSession(androidx.compose.ui.node.Owner r7, kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<?> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = (androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L30;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2c:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L48
        L30:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r6
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor r3 = r2.parent
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2 r4 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2
            r5 = 0
            r4.<init>(r8, r2, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 1
            r0.label = r5
            java.lang.Object r7 = androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.access$interceptedTextInputSession(r7, r3, r4, r0)
            if (r7 != r1) goto L48
            return r1
        L48:
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.textInputSession(androidx.compose.ui.node.Owner, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2", f = "PlatformTextInputModifierNode.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
        final /* synthetic */ Function2<PlatformTextInputSessionScope, Continuation<?>, Object> $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$session = function2;
            this.this$0 = chainedPlatformTextInputInterceptor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$session, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation<?> continuation) {
            return ((AnonymousClass2) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PlatformTextInputSessionScope parentSession = (PlatformTextInputSessionScope) this.L$0;
                    AtomicReference inputMethodMutex = SessionMutex.m3794constructorimpl();
                    ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 scope = new ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1(parentSession, inputMethodMutex, this.this$0);
                    Function2<PlatformTextInputSessionScope, Continuation<?>, Object> function2 = this.$session;
                    this.label = 1;
                    if (function2.invoke(scope, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }
}

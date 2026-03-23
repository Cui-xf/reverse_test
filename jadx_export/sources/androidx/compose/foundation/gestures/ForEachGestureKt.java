package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.core.location.LocationRequestCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ForEachGesture.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a;\u0010\u000f\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0087@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ForEachGestureKt {

    /* compiled from: ForEachGesture.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0}, l = {86}, m = "awaitAllPointersUp", n = {"$this$awaitAllPointersUp"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) null, this);
        }
    }

    /* compiled from: ForEachGesture.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {48, 51, 56}, m = "forEachGesture", n = {"$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.forEachGesture(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0095 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b3 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @kotlin.ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope r6, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ForEachGestureKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L63;
                case 1: goto L51;
                case 2: goto L3f;
                case 3: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2c:
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r3 = r6
            r6 = r2
            goto Lb5
        L3f:
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.util.concurrent.CancellationException -> L61
            r3 = r6
            r6 = r2
            goto L97
        L51:
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.util.concurrent.CancellationException -> L61
            goto L85
        L61:
            r3 = move-exception
            goto L9d
        L63:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r0.getContext()
        L6c:
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r3)
            if (r2 == 0) goto Lb7
        L73:
            r0.L$0 = r6     // Catch: java.util.concurrent.CancellationException -> L98
            r0.L$1 = r7     // Catch: java.util.concurrent.CancellationException -> L98
            r0.L$2 = r3     // Catch: java.util.concurrent.CancellationException -> L98
            r2 = 1
            r0.label = r2     // Catch: java.util.concurrent.CancellationException -> L98
            java.lang.Object r2 = r7.invoke(r6, r0)     // Catch: java.util.concurrent.CancellationException -> L98
            if (r2 != r1) goto L83
            return r1
        L83:
            r2 = r6
            r6 = r3
        L85:
            r0.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L61
            r0.L$1 = r7     // Catch: java.util.concurrent.CancellationException -> L61
            r0.L$2 = r6     // Catch: java.util.concurrent.CancellationException -> L61
            r3 = 2
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L61
            java.lang.Object r3 = awaitAllPointersUp(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L61
            if (r3 != r1) goto L95
            return r1
        L95:
            r3 = r6
            r6 = r2
        L97:
            goto L6c
        L98:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r3
            r3 = r5
        L9d:
            boolean r4 = kotlinx.coroutines.JobKt.isActive(r6)
            if (r4 == 0) goto Lb6
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r6
            r3 = 3
            r0.label = r3
            java.lang.Object r3 = awaitAllPointersUp(r2, r0)
            if (r3 != r1) goto Lb3
            return r1
        Lb3:
            r3 = r6
            r6 = r2
        Lb5:
            goto L6c
        Lb6:
            throw r3
        Lb7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean allPointersUp(AwaitPointerEventScope $this$allPointersUp) {
        boolean z;
        List $this$fastAny$iv = $this$allPointersUp.getCurrentEvent().getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.getPressed()) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        return !z;
    }

    /* compiled from: ForEachGesture.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2", f = "ForEachGesture.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2, reason: invalid class name */
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AwaitPointerEventScope $this$awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.awaitAllPointersUp($this$awaitPointerEventScope, this) != coroutine_suspended) {
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
            return Unit.INSTANCE;
        }
    }

    public static final Object awaitAllPointersUp(PointerInputScope $this$awaitAllPointersUp, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = $this$awaitAllPointersUp.awaitPointerEventScope(new AnonymousClass2(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (allPointersUp(r14) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:19:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ForEachGestureKt.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L2d:
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r2 = r1
            r1 = r0
            r0 = r15
            goto L53
        L38:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r2 = allPointersUp(r14)
            if (r2 != 0) goto L86
        L41:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r2 = r14.awaitPointerEvent(r2, r0)
            if (r2 != r1) goto L4e
            return r1
        L4e:
            r13 = r0
            r0 = r15
            r15 = r2
            r2 = r1
            r1 = r13
        L53:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.util.List r15 = r15.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r15.size()
        L63:
            if (r6 >= r7) goto L7b
            java.lang.Object r8 = r15.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L77
            r15 = 1
            goto L7d
        L77:
            int r6 = r6 + 1
            goto L63
        L7b:
            r15 = 0
        L7d:
            if (r15 != 0) goto L82
            r15 = r0
            r0 = r1
            goto L86
        L82:
            r15 = r0
            r0 = r1
            r1 = r2
            goto L41
        L86:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: ForEachGesture.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", i = {0, 1, 2}, l = {LocationRequestCompat.QUALITY_LOW_POWER, 107, 112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2, reason: invalid class name and case insensitive filesystem */
    static final class C02492 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineContext $currentContext;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02492(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C02492> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02492 c02492 = new C02492(this.$currentContext, this.$block, continuation);
            c02492.L$0 = obj;
            return c02492;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02492) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: CancellationException -> 0x002c, TRY_ENTER, TryCatch #0 {CancellationException -> 0x002c, blocks: (B:18:0x003f, B:21:0x004d, B:8:0x001f, B:11:0x0028), top: B:34:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0059 -> B:16:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0071 -> B:16:0x0036). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                switch(r1) {
                    case 0: goto L2e;
                    case 1: goto L23;
                    case 2: goto L1a;
                    case 3: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L11:
                r1 = r5
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r6)
                goto L74
            L1a:
                r1 = r5
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.util.concurrent.CancellationException -> L2c
                goto L5c
            L23:
                r1 = r5
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.util.concurrent.CancellationException -> L2c
                goto L4d
            L2c:
                r3 = move-exception
                goto L5d
            L2e:
                kotlin.ResultKt.throwOnFailure(r6)
                r1 = r5
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            L36:
                kotlin.coroutines.CoroutineContext r3 = r1.$currentContext
                boolean r3 = kotlinx.coroutines.JobKt.isActive(r3)
                if (r3 == 0) goto L76
            L3f:
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r1.$block     // Catch: java.util.concurrent.CancellationException -> L2c
                r1.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L2c
                r4 = 1
                r1.label = r4     // Catch: java.util.concurrent.CancellationException -> L2c
                java.lang.Object r3 = r3.invoke(r2, r1)     // Catch: java.util.concurrent.CancellationException -> L2c
                if (r3 != r0) goto L4d
                return r0
            L4d:
                r3 = r1
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.util.concurrent.CancellationException -> L2c
                r1.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L2c
                r4 = 2
                r1.label = r4     // Catch: java.util.concurrent.CancellationException -> L2c
                java.lang.Object r3 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(r2, r3)     // Catch: java.util.concurrent.CancellationException -> L2c
                if (r3 != r0) goto L5c
                return r0
            L5c:
                goto L36
            L5d:
                kotlin.coroutines.CoroutineContext r4 = r1.$currentContext
                boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
                if (r4 == 0) goto L75
                r3 = r1
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r1.L$0 = r2
                r4 = 3
                r1.label = r4
                java.lang.Object r3 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(r2, r3)
                if (r3 != r0) goto L74
                return r0
            L74:
                goto L36
            L75:
                throw r3
            L76:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.C02492.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object awaitEachGesture(PointerInputScope $this$awaitEachGesture, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        CoroutineContext currentContext = continuation.getContext();
        Object objAwaitPointerEventScope = $this$awaitEachGesture.awaitPointerEventScope(new C02492(currentContext, function2, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }
}

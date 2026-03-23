package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1", f = "Transformable.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TransformableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransformableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableNode$pointerInputNode$1(TransformableNode transformableNode, Continuation<? super TransformableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = transformableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableNode$pointerInputNode$1 transformableNode$pointerInputNode$1 = new TransformableNode$pointerInputNode$1(this.this$0, continuation);
        transformableNode$pointerInputNode$1.L$0 = obj;
        return transformableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                if (!this.this$0.enabled) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$SuspendingPointerInputModifierNode, this.this$0, null), this) != coroutine_suspended) {
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

    /* compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1", f = "Transformable.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TransformableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, TransformableNode transformableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = transformableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1", f = "Transformable.kt", i = {0, 0, 1}, l = {158, 161}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch"}, s = {"L$0", "L$1", "L$0"})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00291(TransformableNode transformableNode, Continuation<? super C00291> continuation) {
                super(2, continuation);
                this.this$0 = transformableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00291 c00291 = new C00291(this.this$0, continuation);
                c00291.L$0 = obj;
                return c00291;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0094 -> B:13:0x003b). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009a -> B:13:0x003b). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009f -> B:13:0x003b). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r9.label
                    switch(r1) {
                        case 0: goto L33;
                        case 1: goto L1d;
                        case 2: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L11:
                    r1 = r9
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.util.concurrent.CancellationException -> L1b
                    goto L98
                L1b:
                    r3 = move-exception
                    goto L3b
                L1d:
                    r1 = r9
                    java.lang.Object r2 = r1.L$2
                    kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                    java.lang.Object r3 = r1.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                    java.lang.Object r4 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                    kotlin.ResultKt.throwOnFailure(r10)
                    r5 = r3
                    r3 = r2
                    r2 = r1
                    r1 = r0
                    r0 = r10
                    goto L66
                L33:
                    kotlin.ResultKt.throwOnFailure(r10)
                    r1 = r9
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                L3b:
                    boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)
                    if (r3 == 0) goto La4
                    kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
                    r3.<init>()
                    androidx.compose.foundation.gestures.TransformableNode r4 = r1.this$0
                    kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r4)
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r1.L$0 = r2
                    r1.L$1 = r3
                    r1.L$2 = r3
                    r6 = 1
                    r1.label = r6
                    java.lang.Object r4 = r4.receive(r5)
                    if (r4 != r0) goto L5f
                    return r0
                L5f:
                    r5 = r0
                    r0 = r10
                    r10 = r4
                    r4 = r2
                    r2 = r1
                    r1 = r5
                    r5 = r3
                L66:
                    r3.element = r10
                    T r10 = r5.element
                    boolean r10 = r10 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                    if (r10 == 0) goto L9f
                L6f:
                    androidx.compose.foundation.gestures.TransformableNode r10 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L99
                    androidx.compose.foundation.gestures.TransformableState r10 = androidx.compose.foundation.gestures.TransformableNode.access$getState$p(r10)     // Catch: java.util.concurrent.CancellationException -> L99
                    androidx.compose.foundation.MutatePriority r3 = androidx.compose.foundation.MutatePriority.UserInput     // Catch: java.util.concurrent.CancellationException -> L99
                    androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1 r6 = new androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1     // Catch: java.util.concurrent.CancellationException -> L99
                    androidx.compose.foundation.gestures.TransformableNode r7 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L99
                    r8 = 0
                    r6.<init>(r5, r7, r8)     // Catch: java.util.concurrent.CancellationException -> L99
                    kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.util.concurrent.CancellationException -> L99
                    r7 = r2
                    kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.util.concurrent.CancellationException -> L99
                    r2.L$0 = r4     // Catch: java.util.concurrent.CancellationException -> L99
                    r2.L$1 = r8     // Catch: java.util.concurrent.CancellationException -> L99
                    r2.L$2 = r8     // Catch: java.util.concurrent.CancellationException -> L99
                    r8 = 2
                    r2.label = r8     // Catch: java.util.concurrent.CancellationException -> L99
                    java.lang.Object r10 = r10.transform(r3, r6, r7)     // Catch: java.util.concurrent.CancellationException -> L99
                    if (r10 != r1) goto L94
                    return r1
                L94:
                    r10 = r0
                    r0 = r1
                    r1 = r2
                    r2 = r4
                L98:
                    goto L3b
                L99:
                    r10 = move-exception
                    r10 = r0
                    r0 = r1
                    r1 = r2
                    r2 = r4
                    goto L3b
                L9f:
                    r10 = r0
                    r0 = r1
                    r1 = r2
                    r2 = r4
                    goto L3b
                La4:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00291.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1", f = "Transformable.kt", i = {0}, l = {166}, m = "invokeSuspend", n = {"$this$transform"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00301 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.ObjectRef<TransformEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ TransformableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00301(Ref.ObjectRef<TransformEvent> objectRef, TransformableNode transformableNode, Continuation<? super C00301> continuation) {
                    super(2, continuation);
                    this.$event = objectRef;
                    this.this$0 = transformableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00301 c00301 = new C00301(this.$event, this.this$0, continuation);
                    c00301.L$0 = obj;
                    return c00301;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
                    return ((C00301) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:20:0x0074). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        switch(r1) {
                            case 0: goto L23;
                            case 1: goto L11;
                            default: goto L9;
                        }
                    L9:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L11:
                        r1 = r10
                        java.lang.Object r2 = r1.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                        java.lang.Object r3 = r1.L$0
                        androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                        kotlin.ResultKt.throwOnFailure(r11)
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r0
                        r0 = r11
                        goto L74
                    L23:
                        kotlin.ResultKt.throwOnFailure(r11)
                        r1 = r10
                        java.lang.Object r2 = r1.L$0
                        androidx.compose.foundation.gestures.TransformScope r2 = (androidx.compose.foundation.gestures.TransformScope) r2
                        r3 = r2
                    L2c:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                        T r2 = r2.element
                        boolean r2 = r2 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                        if (r2 != 0) goto L7b
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                        T r2 = r2.element
                        boolean r4 = r2 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                        if (r4 == 0) goto L3f
                        androidx.compose.foundation.gestures.TransformEvent$TransformDelta r2 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r2
                        goto L40
                    L3f:
                        r2 = 0
                    L40:
                        if (r2 == 0) goto L54
                        r4 = 0
                        float r5 = r2.getZoomChange()
                        long r6 = r2.getPanChange()
                        float r8 = r2.getRotationChange()
                        r3.mo398transformByd4ec7I(r5, r6, r8)
                    L54:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                        androidx.compose.foundation.gestures.TransformableNode r4 = r1.this$0
                        kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r4)
                        r5 = r1
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        r1.L$0 = r3
                        r1.L$1 = r2
                        r6 = 1
                        r1.label = r6
                        java.lang.Object r4 = r4.receive(r5)
                        if (r4 != r0) goto L6d
                        return r0
                    L6d:
                        r9 = r0
                        r0 = r11
                        r11 = r4
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r9
                    L74:
                        r3.element = r11
                        r11 = r0
                        r0 = r1
                        r1 = r2
                        r3 = r4
                        goto L2c
                    L7b:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00291.C00301.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00291(this.this$0, null), 1, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$$this$SuspendingPointerInputModifierNode, new AnonymousClass2(this.this$0, $this$coroutineScope, null), this) != coroutine_suspended) {
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

        /* compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2", f = "Transformable.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransformableNode transformableNode, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = transformableNode;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$$this$coroutineScope, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0064 A[Catch: all -> 0x0016, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:23:0x0058, B:28:0x0064), top: B:31:0x0006 }] */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r0v3 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r9.label
                    switch(r1) {
                        case 0: goto L1a;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L11:
                    r0 = r9
                    kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L16 java.util.concurrent.CancellationException -> L18
                    goto L43
                L16:
                    r1 = move-exception
                    goto L65
                L18:
                    r1 = move-exception
                    goto L58
                L1a:
                    kotlin.ResultKt.throwOnFailure(r10)
                    r1 = r9
                    java.lang.Object r2 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                    androidx.compose.foundation.gestures.TransformableNode r3 = r1.this$0     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    boolean r3 = androidx.compose.foundation.gestures.TransformableNode.access$getLockRotationOnZoomPan$p(r3)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    androidx.compose.foundation.gestures.TransformableNode r4 = r1.this$0     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r4)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    androidx.compose.foundation.gestures.TransformableNode r5 = r1.this$0     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    kotlin.jvm.functions.Function1 r5 = androidx.compose.foundation.gestures.TransformableNode.access$getUpdatedCanPan$p(r5)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    r7 = 1
                    r1.label = r7     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    java.lang.Object r3 = androidx.compose.foundation.gestures.TransformableKt.access$detectZoom(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L54
                    if (r3 != r0) goto L42
                    return r0
                L42:
                    r0 = r1
                L43:
                    androidx.compose.foundation.gestures.TransformableNode r1 = r0.this$0
                    kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r1)
                    androidx.compose.foundation.gestures.TransformEvent$TransformStopped r2 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
                    r1.mo8489trySendJP2dKIU(r2)
                    goto L61
                L4f:
                    r0 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                    goto L65
                L54:
                    r0 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                L58:
                    kotlinx.coroutines.CoroutineScope r2 = r0.$$this$coroutineScope     // Catch: java.lang.Throwable -> L16
                    boolean r2 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)     // Catch: java.lang.Throwable -> L16
                    if (r2 == 0) goto L64
                    goto L43
                L61:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                L64:
                    throw r1     // Catch: java.lang.Throwable -> L16
                L65:
                    androidx.compose.foundation.gestures.TransformableNode r2 = r0.this$0
                    kotlinx.coroutines.channels.Channel r2 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r2)
                    androidx.compose.foundation.gestures.TransformEvent$TransformStopped r3 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
                    r2.mo8489trySendJP2dKIU(r3)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }
}

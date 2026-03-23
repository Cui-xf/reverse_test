package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.core.location.LocationRequestCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006("}, d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0}, l = {425}, m = "awaitDown", n = {"$this$awaitDown"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.awaitDown(null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1}, l = {158, 181}, m = "mouseSelection", n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1, reason: invalid class name and case insensitive filesystem */
    static final class C03651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03651(Continuation<? super C03651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelection(null, null, null, null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1}, l = {351, 377}, m = "mouseSelectionBtf2", n = {"$this$mouseSelectionBtf2", "observer", "$this$mouseSelectionBtf2", "observer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1, reason: invalid class name and case insensitive filesystem */
    static final class C03661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03661(Continuation<? super C03661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelectionBtf2(null, null, null, null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {124, 128}, m = "touchSelection", n = {"$this$touchSelection", "observer", "firstDown", "$this$touchSelection", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1, reason: invalid class name and case insensitive filesystem */
    static final class C03681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03681(Continuation<? super C03681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelection(null, null, null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {238, 241}, m = "touchSelectionFirstPress", n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1, reason: invalid class name and case insensitive filesystem */
    static final class C03701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03701(Continuation<? super C03701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {276, 315}, m = "touchSelectionSubsequentPress", n = {"$this$touchSelectionSubsequentPress", "observer", "firstDown", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1, reason: invalid class name and case insensitive filesystem */
    static final class C03711 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C03711(Continuation<? super C03711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionSubsequentPress(null, null, null, this);
        }
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1", f = "SelectionGestures.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1, reason: invalid class name and case insensitive filesystem */
    static final class C03721 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03721(Function1<? super Boolean, Unit> function1, Continuation<? super C03721> continuation) {
            super(2, continuation);
            this.$updateTouchMode = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03721 c03721 = new C03721(this.$updateTouchMode, continuation);
            c03721.L$0 = obj;
            return c03721;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C03721) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SelectionGestures.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", f = "SelectionGestures.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00621 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00621(Function1<? super Boolean, Unit> function1, Continuation<? super C00621> continuation) {
                super(2, continuation);
                this.$updateTouchMode = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00621 c00621 = new C00621(this.$updateTouchMode, continuation);
                c00621.L$0 = obj;
                return c00621;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00621) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0037 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:12:0x003e). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r8.label
                    r2 = 1
                    switch(r1) {
                        case 0: goto L1f;
                        case 1: goto L12;
                        default: goto La;
                    }
                La:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L12:
                    r1 = r8
                    java.lang.Object r3 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    kotlin.ResultKt.throwOnFailure(r9)
                    r4 = r3
                    r3 = r1
                    r1 = r0
                    r0 = r9
                    goto L3e
                L1f:
                    kotlin.ResultKt.throwOnFailure(r9)
                    r1 = r8
                    java.lang.Object r3 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                L27:
                    androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r1.L$0 = r3
                    r1.label = r2
                    java.lang.Object r4 = r3.awaitPointerEvent(r4, r5)
                    if (r4 != r0) goto L38
                    return r0
                L38:
                    r7 = r0
                    r0 = r9
                    r9 = r4
                    r4 = r3
                    r3 = r1
                    r1 = r7
                L3e:
                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r5 = r3.$updateTouchMode
                    boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r9)
                    if (r6 != 0) goto L4a
                    r9 = 1
                    goto L4b
                L4a:
                    r9 = 0
                L4b:
                    java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
                    r5.invoke(r9)
                    r9 = r0
                    r0 = r1
                    r1 = r3
                    r3 = r4
                    goto L27
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C03721.C00621.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if ($this$pointerInput.awaitPointerEventScope(new C00621(this.$updateTouchMode, null), this) != coroutine_suspended) {
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

    public static final Modifier updateSelectionTouchMode(Modifier $this$updateSelectionTouchMode, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput($this$updateSelectionTouchMode, Integer.valueOf(STATIC_KEY), new C03721(function1, null));
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1", f = "SelectionGestures.kt", i = {}, l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1, reason: invalid class name and case insensitive filesystem */
    static final class C03671 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03671(MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super C03671> continuation) {
            super(2, continuation);
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03671 c03671 = new C03671(this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            c03671.L$0 = obj;
            return c03671;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C03671) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    ClicksCounter clicksCounter = new ClicksCounter($this$pointerInput.getViewConfiguration());
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture($this$pointerInput, new C00611(this.$mouseSelectionObserver, clicksCounter, this.$textDragObserver, null), this) != coroutine_suspended) {
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

        /* compiled from: SelectionGestures.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", i = {0}, l = {105, 111, 113}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00611 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ClicksCounter $clicksCounter;
            final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
            final /* synthetic */ TextDragObserver $textDragObserver;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00611(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super C00611> continuation) {
                super(2, continuation);
                this.$mouseSelectionObserver = mouseSelectionObserver;
                this.$clicksCounter = clicksCounter;
                this.$textDragObserver = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00611 c00611 = new C00611(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                c00611.L$0 = obj;
                return c00611;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00611) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[SYNTHETIC] */
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
                    r3 = 1
                    switch(r2) {
                        case 0: goto L33;
                        case 1: goto L26;
                        case 2: goto L1d;
                        case 3: goto L14;
                        default: goto Lc;
                    }
                Lc:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r2)
                    throw r0
                L14:
                    r0 = r18
                    r2 = r19
                    kotlin.ResultKt.throwOnFailure(r2)
                    goto Lc1
                L1d:
                    r0 = r18
                    r2 = r19
                    kotlin.ResultKt.throwOnFailure(r2)
                    goto La5
                L26:
                    r2 = r18
                    r4 = r19
                    java.lang.Object r5 = r2.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                    kotlin.ResultKt.throwOnFailure(r4)
                    r6 = r4
                    goto L4c
                L33:
                    kotlin.ResultKt.throwOnFailure(r19)
                    r2 = r18
                    r4 = r19
                    java.lang.Object r5 = r2.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                    r6 = r2
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r2.L$0 = r5
                    r2.label = r3
                    java.lang.Object r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$awaitDown(r5, r6)
                    if (r6 != r0) goto L4c
                    return r0
                L4c:
                    androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
                    boolean r7 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r6)
                    r8 = 0
                    if (r7 == 0) goto La8
                    int r7 = r6.getButtons()
                    boolean r7 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5377isPrimaryPressedaHzCxE(r7)
                    if (r7 == 0) goto La8
                    java.util.List r7 = r6.getChanges()
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    int r12 = r7.size()
                L6e:
                    if (r11 >= r12) goto L8c
                    java.lang.Object r13 = r7.get(r11)
                    r14 = 0
                    androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                    r15 = 0
                    boolean r16 = r13.isConsumed()
                    r17 = 0
                    if (r16 != 0) goto L83
                    r13 = 1
                    goto L84
                L83:
                    r13 = 0
                L84:
                    if (r13 != 0) goto L88
                    r3 = 0
                    goto L8e
                L88:
                    int r11 = r11 + 1
                    goto L6e
                L8c:
                L8e:
                    if (r3 == 0) goto La8
                    androidx.compose.foundation.text.selection.MouseSelectionObserver r3 = r2.$mouseSelectionObserver
                    androidx.compose.foundation.text.selection.ClicksCounter r7 = r2.$clicksCounter
                    r9 = r2
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    r2.L$0 = r8
                    r8 = 2
                    r2.label = r8
                    java.lang.Object r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$mouseSelection(r5, r3, r7, r6, r9)
                    if (r3 != r0) goto La3
                    return r0
                La3:
                    r0 = r2
                    r2 = r4
                La5:
                    r4 = r2
                    r2 = r0
                    goto Lc3
                La8:
                    boolean r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r6)
                    if (r3 != 0) goto Lc3
                    androidx.compose.foundation.text.TextDragObserver r3 = r2.$textDragObserver
                    r7 = r2
                    kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                    r2.L$0 = r8
                    r8 = 3
                    r2.label = r8
                    java.lang.Object r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$touchSelection(r5, r3, r6, r7)
                    if (r3 != r0) goto Lbf
                    return r0
                Lbf:
                    r0 = r2
                    r2 = r4
                Lc1:
                    r4 = r2
                    r2 = r0
                Lc3:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C03671.C00611.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public static final Modifier selectionGestureInput(Modifier $this$selectionGestureInput, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput($this$selectionGestureInput, mouseSelectionObserver, textDragObserver, new C03671(mouseSelectionObserver, textDragObserver, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[Catch: CancellationException -> 0x00e2, TryCatch #0 {CancellationException -> 0x00e2, blocks: (B:32:0x00a8, B:34:0x00b0, B:36:0x00c1, B:38:0x00cf, B:39:0x00d2, B:40:0x00d7, B:41:0x00dc, B:18:0x004b, B:25:0x0076, B:27:0x007a, B:29:0x0084, B:21:0x0054), top: B:48:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc A[Catch: CancellationException -> 0x00e2, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00e2, blocks: (B:32:0x00a8, B:34:0x00b0, B:36:0x00c1, B:38:0x00cf, B:39:0x00d2, B:40:0x00d7, B:41:0x00dc, B:18:0x004b, B:25:0x0076, B:27:0x007a, B:29:0x0084, B:21:0x0054), top: B:48:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, final androidx.compose.foundation.text.TextDragObserver r8, androidx.compose.ui.input.pointer.PointerEvent r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, final androidx.compose.foundation.text.selection.MouseSelectionObserver r8, androidx.compose.foundation.text.selection.ClicksCounter r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: SelectionGestures.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", i = {0}, l = {209, 217, 220, 221}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2, reason: invalid class name */
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$clicksCounter = clicksCounter;
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009a A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope $this$selectionGesturePointerInputBtf2, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        ClicksCounter clicksCounter = new ClicksCounter($this$selectionGesturePointerInputBtf2.getViewConfiguration());
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$selectionGesturePointerInputBtf2, new AnonymousClass2(clicksCounter, mouseSelectionObserver, textDragObserver, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[Catch: CancellationException -> 0x00e0, TryCatch #0 {CancellationException -> 0x00e0, blocks: (B:32:0x00a6, B:34:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00d0, B:40:0x00d5, B:41:0x00da, B:18:0x004a, B:25:0x0075, B:27:0x0079, B:29:0x0083, B:21:0x0053), top: B:48:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da A[Catch: CancellationException -> 0x00e0, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00e0, blocks: (B:32:0x00a6, B:34:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00d0, B:40:0x00d5, B:41:0x00da, B:18:0x004a, B:25:0x0075, B:27:0x0079, B:29:0x0083, B:21:0x0053), top: B:48:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, final androidx.compose.foundation.text.TextDragObserver r8, androidx.compose.ui.input.pointer.PointerEvent r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6 A[Catch: CancellationException -> 0x003b, TryCatch #0 {CancellationException -> 0x003b, blocks: (B:13:0x0035, B:44:0x00e3, B:46:0x00eb, B:48:0x00fc, B:50:0x010a, B:51:0x010d, B:52:0x0112, B:53:0x0117, B:27:0x00a2, B:29:0x00a6, B:30:0x00a8, B:32:0x00ad, B:34:0x00b0, B:36:0x00bb, B:38:0x00c1, B:40:0x00c5, B:41:0x00ca), top: B:60:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[Catch: CancellationException -> 0x003b, TryCatch #0 {CancellationException -> 0x003b, blocks: (B:13:0x0035, B:44:0x00e3, B:46:0x00eb, B:48:0x00fc, B:50:0x010a, B:51:0x010d, B:52:0x0112, B:53:0x0117, B:27:0x00a2, B:29:0x00a6, B:30:0x00a8, B:32:0x00ad, B:34:0x00b0, B:36:0x00bb, B:38:0x00c1, B:40:0x00c5, B:41:0x00ca), top: B:60:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[Catch: CancellationException -> 0x003b, TryCatch #0 {CancellationException -> 0x003b, blocks: (B:13:0x0035, B:44:0x00e3, B:46:0x00eb, B:48:0x00fc, B:50:0x010a, B:51:0x010d, B:52:0x0112, B:53:0x0117, B:27:0x00a2, B:29:0x00a6, B:30:0x00a8, B:32:0x00ad, B:34:0x00b0, B:36:0x00bb, B:38:0x00c1, B:40:0x00c5, B:41:0x00ca), top: B:60:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb A[Catch: CancellationException -> 0x003b, TryCatch #0 {CancellationException -> 0x003b, blocks: (B:13:0x0035, B:44:0x00e3, B:46:0x00eb, B:48:0x00fc, B:50:0x010a, B:51:0x010d, B:52:0x0112, B:53:0x0117, B:27:0x00a2, B:29:0x00a6, B:30:0x00a8, B:32:0x00ad, B:34:0x00b0, B:36:0x00bb, B:38:0x00c1, B:40:0x00c5, B:41:0x00ca), top: B:60:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0117 A[Catch: CancellationException -> 0x003b, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x003b, blocks: (B:13:0x0035, B:44:0x00e3, B:46:0x00eb, B:48:0x00fc, B:50:0x010a, B:51:0x010d, B:52:0x0112, B:53:0x0117, B:27:0x00a2, B:29:0x00a6, B:30:0x00a8, B:32:0x00ad, B:34:0x00b0, B:36:0x00bb, B:38:0x00c1, B:40:0x00c5, B:41:0x00ca), top: B:60:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [androidx.compose.foundation.text.TextDragObserver] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r12, androidx.compose.foundation.text.TextDragObserver r13, androidx.compose.ui.input.pointer.PointerEvent r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[Catch: all -> 0x004a, TryCatch #2 {all -> 0x004a, blocks: (B:18:0x0045, B:30:0x008b, B:32:0x0093, B:34:0x00a4, B:36:0x00b2), top: B:75:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116 A[Catch: all -> 0x003a, TryCatch #3 {all -> 0x003a, blocks: (B:13:0x0034, B:55:0x010e, B:57:0x0116, B:59:0x0127, B:61:0x0135), top: B:77:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, final androidx.compose.foundation.text.selection.MouseSelectionObserver r8, androidx.compose.foundation.text.selection.ClicksCounter r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004e -> B:18:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r1 = (androidx.compose.foundation.text.selection.SelectionGesturesKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r1 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            switch(r3) {
                case 0: goto L3b;
                case 1: goto L2f;
                default: goto L27;
            }
        L27:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2f:
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            goto L56
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r17
        L41:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r1.L$0 = r3
            r1.label = r4
            java.lang.Object r5 = r3.awaitPointerEvent(r5, r1)
            if (r5 != r2) goto L4e
            return r2
        L4e:
            r16 = r1
            r1 = r0
            r0 = r5
            r5 = r3
            r3 = r2
            r2 = r16
        L56:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r6 = r0.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r6.size()
        L66:
            if (r9 >= r10) goto L7e
            java.lang.Object r11 = r6.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r14)
            if (r14 != 0) goto L7a
            r10 = 0
            goto L80
        L7a:
            int r9 = r9 + 1
            goto L66
        L7e:
            r10 = 1
        L80:
            if (r10 == 0) goto L83
            return r0
        L83:
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r5
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange change1, PointerInputChange change2) {
        float slop = DragGestureDetectorKt.m419pointerSlopE8SPZFQ(viewConfiguration, change1.getType());
        return Offset.m3943getDistanceimpl(Offset.m3949minusMKHz9U(change1.getPosition(), change2.getPosition())) < slop;
    }

    public static final boolean isPrecisePointer(PointerEvent $this$isPrecisePointer) {
        List $this$fastAll$iv = $this$isPrecisePointer.getChanges();
        int size = $this$fastAll$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (!PointerType.m5477equalsimpl0(it.getType(), PointerType.INSTANCE.m5482getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}

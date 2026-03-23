package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0093\u0001\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a0\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u0010&\u001a\u00020\u0017H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aE\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u00100\u001a\u00020\u0017H\u0007¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063²\u0006\n\u00104\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "modalBottomSheetAnchors", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m6693constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m6693constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = Dp.m6693constructorimpl(640);

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean skipHalfExpanded, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -126412120, "C(rememberModalBottomSheetState)P(2)291@11506L7:ModalBottomSheet.kt#jmzs0o");
        final AnimationSpec animationSpec2 = (i & 2) != 0 ? ModalBottomSheetDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        final Function1 confirmValueChange = (i & 4) != 0 ? new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ModalBottomSheetValue it) {
                return true;
            }
        } : function1;
        final boolean skipHalfExpanded2 = (i & 8) != 0 ? false : skipHalfExpanded;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:290)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        $composer.startMovableGroup(976449919, initialValue);
        ComposerKt.sourceInformation($composer, "304@12115L298,296@11767L646");
        Object[] objArr = {initialValue, animationSpec2, Boolean.valueOf(skipHalfExpanded2), confirmValueChange, density};
        Saver<ModalBottomSheetState, ?> Saver = ModalBottomSheetState.INSTANCE.Saver(animationSpec2, confirmValueChange, skipHalfExpanded2, density);
        ComposerKt.sourceInformationMarkerStart($composer, 976461569, "CC(remember):ModalBottomSheet.kt#9igjgp");
        boolean invalid$iv = (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(skipHalfExpanded2)) || ($changed & 3072) == 2048) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density) | (((($changed & 896) ^ 384) > 256 && $composer.changed(confirmValueChange)) || ($changed & 384) == 256) | $composer.changedInstance(animationSpec2);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ModalBottomSheetState invoke() {
                    return new ModalBottomSheetState(initialValue, density, confirmValueChange, animationSpec2, skipHalfExpanded2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modalBottomSheetState;
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x06ee  */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1597ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, androidx.compose.ui.Modifier r64, androidx.compose.material.ModalBottomSheetState r65, boolean r66, androidx.compose.ui.graphics.Shape r67, float r68, long r69, long r71, long r73, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instructions count: 1817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m1597ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Modifier modalBottomSheetAnchors(Modifier $this$modalBottomSheetAnchors, final ModalBottomSheetState sheetState) {
        return AnchoredDraggableKt.draggableAnchors($this$modalBottomSheetAnchors, sheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue>>() { // from class: androidx.compose.material.ModalBottomSheetKt.modalBottomSheetAnchors.1

            /* compiled from: ModalBottomSheet.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue> invoke(IntSize intSize, Constraints constraints) {
                return m1601invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
            }

            /* renamed from: invoke-GpV2Q24, reason: not valid java name */
            public final Pair<DraggableAnchors<ModalBottomSheetValue>, ModalBottomSheetValue> m1601invokeGpV2Q24(final long sheetSize, long constraints) {
                ModalBottomSheetValue newTarget;
                final float fullHeight = Constraints.m6635getMaxHeightimpl(constraints);
                final ModalBottomSheetState modalBottomSheetState = sheetState;
                DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<ModalBottomSheetValue>, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(ModalBottomSheetValue.Hidden, fullHeight);
                        float halfHeight = fullHeight / 2.0f;
                        if (!modalBottomSheetState.getIsSkipHalfExpanded() && IntSize.m6866getHeightimpl(sheetSize) > halfHeight) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.HalfExpanded, halfHeight);
                        }
                        if (IntSize.m6866getHeightimpl(sheetSize) != 0) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.Expanded, Math.max(0.0f, fullHeight - IntSize.m6866getHeightimpl(sheetSize)));
                        }
                    }
                });
                boolean isInitialized = sheetState.getAnchoredDraggableState$material_release().getAnchors().getSize() > 0;
                ModalBottomSheetValue previousValue = sheetState.getCurrentValue();
                if (!isInitialized && newAnchors.hasAnchorFor(previousValue)) {
                    newTarget = previousValue;
                } else {
                    switch (WhenMappings.$EnumSwitchMapping$0[sheetState.getTargetValue().ordinal()]) {
                        case 1:
                            newTarget = ModalBottomSheetValue.Hidden;
                            break;
                        case 2:
                        case 3:
                            boolean hasHalfExpandedState = newAnchors.hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
                            if (hasHalfExpandedState) {
                                newTarget = ModalBottomSheetValue.HalfExpanded;
                                break;
                            } else if (newAnchors.hasAnchorFor(ModalBottomSheetValue.Expanded)) {
                                newTarget = ModalBottomSheetValue.Expanded;
                                break;
                            } else {
                                newTarget = ModalBottomSheetValue.Hidden;
                                break;
                            }
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                return TuplesKt.to(newAnchors, newTarget);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1598Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        ModalBottomSheetKt$Scrim$dismissModifier$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color):ModalBottomSheet.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, $dirty, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:495)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                $composer2.startReplaceGroup(477259505);
                ComposerKt.sourceInformation($composer2, "497@20564L121,501@20711L29,517@21226L62,513@21117L171");
                int $dirty2 = $dirty;
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1065353216 : 0, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeSheet = Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1669getCloseSheetUdPEhr4(), $composer2, 6);
                if (visible) {
                    $composer2.startReplaceGroup(477486053);
                    ComposerKt.sourceInformation($composer2, "504@20848L37,505@20938L121");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1262330565, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1262333529, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changed(closeSheet) | (($dirty2 & 112) == 32);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setContentDescription($this$semantics, closeSheet);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissModifier = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(477766882);
                    $composer2.endReplaceGroup();
                    dismissModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, 1262342686, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(alpha$delegate) | (($dirty2 & 14) == 4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$Canvas) {
                            DrawScope.CC.m4747drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, ModalBottomSheetKt.Scrim_3J_VO9M$lambda$6(alpha$delegate), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(477983138);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ModalBottomSheetKt.m1598Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* compiled from: ModalBottomSheet.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo479onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo477onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo478onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                r0.<init>(r6, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                switch(r2) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2c:
                long r7 = r0.J$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L61
            L32:
                kotlin.ResultKt.throwOnFailure(r9)
                r2 = r6
                float r3 = r2.velocityToFloat(r7)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r4 = r4.requireOffset()
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 >= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
                androidx.compose.material.DraggableAnchors r5 = r5.getAnchors()
                float r5 = r5.minAnchor()
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 <= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                r0.J$0 = r7
                r5 = 1
                r0.label = r5
                java.lang.Object r2 = r4.settle(r3, r0)
                if (r2 != r1) goto L61
                return r1
            L61:
                goto L68
            L62:
                androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r7 = r7.m6945getZero9UxMQ8M()
            L68:
                androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.AnonymousClass1.mo478onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo476onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r4 = this;
                boolean r5 = r9 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                r5.<init>(r4, r9)
            L19:
                java.lang.Object r6 = r5.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                switch(r0) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2c:
                long r7 = r5.J$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                r0 = r4
                androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
                float r2 = r0.velocityToFloat(r7)
                r5.J$0 = r7
                r3 = 1
                r5.label = r3
                java.lang.Object r0 = r1.settle(r2, r5)
                if (r0 != r9) goto L48
                return r9
            L48:
                androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.AnonymousClass1.mo476onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m6934getXimpl($this$toFloat) : Velocity.m6935getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m3945getXimpl($this$toFloat) : Offset.m3946getYimpl($this$toFloat);
        }
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }
}

package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0088\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aq\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m6693constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m6693constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m6693constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m6693constructorimpl(20);

    /* renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m1584FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        long j;
        final long contentColor2;
        Shape shape3;
        long backgroundColor2;
        int $dirty;
        FloatingActionButtonElevation elevation2;
        Shape shape4;
        long backgroundColor3;
        int i2;
        MutableInteractionSource interactionSource3;
        Composer $composer2;
        final Modifier modifier3;
        final MutableInteractionSource interactionSource4;
        final Shape shape5;
        final long backgroundColor4;
        final long contentColor3;
        final FloatingActionButtonElevation elevation3;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(1028985328);
        ComposerKt.sourceInformation($composer3, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)83@3890L6,84@3978L6,85@4022L32,86@4132L11,97@4531L28,99@4619L408,91@4310L717:FloatingActionButton.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            interactionSource2 = interactionSource;
        } else if (($changed & 384) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer3.changed(interactionSource2) ? 256 : 128;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i5 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                j = backgroundColor;
                int i6 = $composer3.changed(j) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                j = backgroundColor;
            }
            $dirty2 |= i6;
        } else {
            j = backgroundColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                int i7 = $composer3.changed(contentColor2) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i7;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer3.changed(elevation)) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            interactionSource4 = interactionSource2;
            $composer2 = $composer3;
            shape5 = shape2;
            backgroundColor4 = j;
            contentColor3 = contentColor2;
            elevation3 = elevation;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                MutableInteractionSource interactionSource5 = i4 != 0 ? null : interactionSource2;
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1496getSecondary0d7_KjU();
                    $dirty2 &= -57345;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty2 >> 12) & 14);
                    $dirty = $dirty2 & (-458753);
                } else {
                    $dirty = $dirty2;
                }
                if ((i & 64) != 0) {
                    long backgroundColor5 = backgroundColor2;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1580elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                    modifier2 = modifier4;
                    $dirty &= -3670017;
                    interactionSource2 = interactionSource5;
                    shape4 = shape3;
                    backgroundColor3 = backgroundColor5;
                    i2 = 1028985328;
                } else {
                    long backgroundColor6 = backgroundColor2;
                    elevation2 = elevation;
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource5;
                    shape4 = shape3;
                    backgroundColor3 = backgroundColor6;
                    i2 = 1028985328;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    int i8 = $dirty2 & (-3670017);
                    elevation2 = elevation;
                    shape4 = shape2;
                    backgroundColor3 = j;
                    $dirty = i8;
                    i2 = 1028985328;
                } else {
                    shape4 = shape2;
                    backgroundColor3 = j;
                    i2 = 1028985328;
                    $dirty = $dirty2;
                    elevation2 = elevation;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
            }
            if (interactionSource2 == null) {
                $composer3.startReplaceGroup(-1991754265);
                ComposerKt.sourceInformation($composer3, "90@4266L39");
                ComposerKt.sourceInformationMarkerStart($composer3, 628486523, "CC(remember):FloatingActionButton.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                interactionSource3 = (MutableInteractionSource) value$iv;
            } else {
                $composer3.startReplaceGroup(628485872);
                $composer3.endReplaceGroup();
                interactionSource3 = interactionSource2;
            }
            long contentColor4 = contentColor2;
            $composer2 = $composer3;
            SurfaceKt.m1677SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                }
            }, 1, null), false, shape4, backgroundColor3, contentColor4, null, elevation2.elevation(interactionSource3, $composer3, ($dirty >> 15) & 112).getValue().m6707unboximpl(), interactionSource3, ComposableLambdaKt.rememberComposableLambda(1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C100@4701L320,100@4629L392:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1972871863, $changed2, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:100)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4189getAlphaimpl(contentColor2)));
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C101@4746L10,101@4765L246,101@4715L296:FloatingActionButton.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1867794295, $changed3, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:101)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography($composer5, 6).getButton();
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            Function0 factory$iv$iv$iv;
                                            ComposerKt.sourceInformation($composer6, "C102@4783L214:FloatingActionButton.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1567914264, $changed4, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:102)");
                                                }
                                                Modifier modifier$iv = SizeKt.m710defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                int $changed$iv$iv = (54 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    factory$iv$iv$iv = factory$iv$iv$iv2;
                                                    $composer6.createNode(factory$iv$iv$iv);
                                                } else {
                                                    factory$iv$iv$iv = factory$iv$iv$iv2;
                                                    $composer6.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer6);
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                                                }
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i9 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i10 = ((54 >> 6) & 112) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1042262326, "C106@4986L9:FloatingActionButton.kt#jmzs0o");
                                                function24.invoke($composer6, 0);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                $composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54), $composer5, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty & 14) | 805306368 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 68);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interactionSource4 = interactionSource2;
            shape5 = shape4;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor4;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    FloatingActionButtonKt.m1584FloatingActionButtonbogVsAg(function0, modifier3, interactionSource4, shape5, backgroundColor4, contentColor3, elevation3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1583ExtendedFloatingActionButtonwqdebIU(Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        final Function2 icon;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        final FloatingActionButtonElevation elevation2;
        int $dirty;
        long backgroundColor2;
        long contentColor2;
        Composer $composer2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        FloatingActionButtonElevation elevation3;
        long contentColor3;
        long contentColor4;
        int $dirty2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer $composer3;
        final Modifier modifier3;
        final Function2 icon2;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final long backgroundColor3;
        final long contentColor5;
        Composer $composer4 = $composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation($composer4, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)152@7254L6,153@7342L6,154@7386L32,155@7496L11,168@7878L487,157@7516L849:FloatingActionButton.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty3 |= $composer4.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
            icon = function22;
        } else if (($changed & 3072) == 0) {
            icon = function22;
            $dirty3 |= $composer4.changedInstance(icon) ? 2048 : 1024;
        } else {
            icon = function22;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
            interactionSource2 = interactionSource;
        } else if (($changed & 24576) == 0) {
            interactionSource2 = interactionSource;
            $dirty3 |= $composer4.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i5 = $composer4.changed(shape2) ? 131072 : 65536;
                $dirty3 |= i5;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            $dirty3 |= ((i & 64) == 0 && $composer4.changed(backgroundColor)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty3 |= ((i & 128) == 0 && $composer4.changed(contentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            if ((i & 256) == 0) {
                elevation2 = elevation;
                int i6 = $composer4.changed(elevation2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty3 |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        if (($dirty3 & 38347923) == 38347922 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            $composer3 = $composer4;
            modifier3 = modifier2;
            icon2 = icon;
            interactionSource4 = interactionSource2;
            shape4 = shape2;
            function23 = function2;
            backgroundColor3 = backgroundColor;
            contentColor5 = contentColor;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    icon = null;
                }
                if (i4 != 0) {
                    interactionSource2 = null;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer4, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty3 & (-3670017);
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer4, 6).m1496getSecondary0d7_KjU();
                } else {
                    $dirty = $dirty3;
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer4, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 256) != 0) {
                    $composer2 = $composer4;
                    elevation3 = FloatingActionButtonDefaults.INSTANCE.m1580elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer4, 24576, 15);
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    contentColor4 = backgroundColor2;
                    $dirty3 = $dirty & (-234881025);
                    $dirty2 = 12582912;
                } else {
                    $composer2 = $composer4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    elevation3 = elevation2;
                    contentColor3 = contentColor2;
                    contentColor4 = backgroundColor2;
                    $dirty3 = $dirty;
                    $dirty2 = 12582912;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    contentColor4 = backgroundColor;
                    contentColor3 = contentColor;
                    $dirty3 &= -234881025;
                    $composer2 = $composer4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    elevation3 = elevation2;
                    $dirty2 = 12582912;
                } else {
                    contentColor4 = backgroundColor;
                    contentColor3 = contentColor;
                    $composer2 = $composer4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    elevation3 = elevation2;
                    $dirty2 = 12582912;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, $dirty3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:156)");
            }
            function23 = function2;
            $composer3 = $composer2;
            m1584FloatingActionButtonbogVsAg(function02, SizeKt.m730sizeInqDBjuR0$default(modifier2, ExtendedFabSize, ExtendedFabSize, 0.0f, 0.0f, 12, null), interactionSource3, shape3, contentColor4, contentColor3, elevation3, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer5, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer5, "C170@7984L375:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, $changed2, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                        }
                        float startPadding = icon == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier modifier$iv = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, startPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function24 = icon;
                        Function2<Composer, Integer, Unit> function25 = function23;
                        ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                        CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer5.startReusableNode();
                        if ($composer5.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer5.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer5.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer5);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i8 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -565187954, "C181@8343L6:FloatingActionButton.kt#jmzs0o");
                        if (function24 != null) {
                            $composer5.startReplaceGroup(-565171246);
                            ComposerKt.sourceInformation($composer5, "178@8247L6,179@8270L46");
                            function24.invoke($composer5, 0);
                            SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), $composer5, 6);
                            $composer5.endReplaceGroup();
                        } else {
                            $composer5.startReplaceGroup(-565074185);
                            $composer5.endReplaceGroup();
                        }
                        function25.invoke($composer5, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer2, 54), $composer3, $dirty2 | (($dirty3 >> 3) & 14) | (($dirty3 >> 6) & 896) | (($dirty3 >> 6) & 7168) | (($dirty3 >> 6) & 57344) | (($dirty3 >> 6) & 458752) | (($dirty3 >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            icon2 = icon;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            backgroundColor3 = contentColor4;
            contentColor5 = contentColor3;
            elevation2 = elevation3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    FloatingActionButtonKt.m1583ExtendedFloatingActionButtonwqdebIU(function24, function0, modifier3, icon2, interactionSource4, shape4, backgroundColor3, contentColor5, elevation2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}

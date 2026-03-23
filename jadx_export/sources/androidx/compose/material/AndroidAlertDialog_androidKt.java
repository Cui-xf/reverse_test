package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m1414AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        final Function2 dismissButton;
        Function2 title;
        Function2 text;
        Shape shape2;
        int $dirty;
        int i2;
        int i3;
        long backgroundColor2;
        int i4;
        long contentColor2;
        DialogProperties properties2;
        long backgroundColor3;
        Function2 title2;
        int $dirty2;
        long contentColor3;
        Modifier modifier3;
        Function2 text2;
        Shape shape3;
        Composer $composer2;
        final Function2 dismissButton2;
        final Modifier modifier4;
        final Function2 title3;
        final Function2 text3;
        final Shape shape4;
        final long backgroundColor4;
        final long contentColor4;
        final DialogProperties properties3;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,77@3743L444,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            dismissButton = function22;
        } else if (($changed & 3072) == 0) {
            dismissButton = function22;
            $dirty4 |= $composer3.changedInstance(dismissButton) ? 2048 : 1024;
        } else {
            dismissButton = function22;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
            title = function23;
        } else if (($changed & 24576) == 0) {
            title = function23;
            $dirty4 |= $composer3.changedInstance(title) ? 16384 : 8192;
        } else {
            title = function23;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            text = function24;
        } else if ((196608 & $changed) == 0) {
            text = function24;
            $dirty4 |= $composer3.changedInstance(text) ? 131072 : 65536;
        } else {
            text = function24;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i9 = $composer3.changed(shape2) ? 1048576 : 524288;
                $dirty4 |= i9;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i9;
        } else {
            shape2 = shape;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                i2 = i5;
                int i10 = $composer3.changed(backgroundColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i10;
            } else {
                $dirty3 = $dirty4;
                i2 = i5;
            }
            $dirty = $dirty3 | i10;
        } else {
            $dirty = $dirty4;
            i2 = i5;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(contentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty5 = $dirty;
        int $dirty6 = i & 512;
        if ($dirty6 != 0) {
            $dirty5 |= 805306368;
            i3 = $dirty6;
        } else if (($changed & 805306368) == 0) {
            i3 = $dirty6;
            $dirty5 |= $composer3.changed(properties) ? 536870912 : 268435456;
        } else {
            i3 = $dirty6;
        }
        if (($dirty5 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            dismissButton2 = dismissButton;
            title3 = title;
            text3 = text;
            shape4 = shape2;
            backgroundColor4 = backgroundColor;
            contentColor4 = contentColor;
            properties3 = properties;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    dismissButton = null;
                }
                if (i7 != 0) {
                    title = null;
                }
                if (i8 != 0) {
                    text = null;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                    i4 = -234881025;
                } else {
                    backgroundColor2 = backgroundColor;
                    i4 = -234881025;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty5 >> 21) & 14);
                    $dirty5 &= i4;
                } else {
                    contentColor2 = contentColor;
                }
                if (i3 != 0) {
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    backgroundColor3 = backgroundColor2;
                    title2 = title;
                    $dirty2 = $dirty5;
                    contentColor3 = contentColor2;
                    modifier3 = modifier2;
                    text2 = text;
                    shape3 = shape2;
                } else {
                    properties2 = properties;
                    backgroundColor3 = backgroundColor2;
                    title2 = title;
                    $dirty2 = $dirty5;
                    contentColor3 = contentColor2;
                    modifier3 = modifier2;
                    text2 = text;
                    shape3 = shape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 = $dirty5 & (-234881025);
                    backgroundColor3 = backgroundColor;
                    contentColor3 = contentColor;
                    properties2 = properties;
                    modifier3 = modifier2;
                    title2 = title;
                    text2 = text;
                    shape3 = shape2;
                } else {
                    backgroundColor3 = backgroundColor;
                    contentColor3 = contentColor;
                    properties2 = properties;
                    title2 = title;
                    text2 = text;
                    shape3 = shape2;
                    $dirty2 = $dirty5;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty2, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
            }
            $composer2 = $composer3;
            m1415AlertDialogwqdebIU(function02, ComposableLambdaKt.rememberComposableLambda(-1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1849673151, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:79)");
                    }
                    Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6693constructorimpl(8), Dp.m6693constructorimpl(2));
                    final Function2<Composer, Integer, Unit> function25 = dismissButton;
                    final Function2<Composer, Integer, Unit> function26 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer4.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i11 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i12 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1897266341, "C83@4064L99,80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                    AlertDialogKt.m1413AlertDialogFlowRowixp7dh8(Dp.m6693constructorimpl(8), Dp.m6693constructorimpl(12), ComposableLambdaKt.rememberComposableLambda(1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                            ComposerKt.sourceInformation($composer5, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                            if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1789213604, $changed3, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:84)");
                                }
                                Function2<Composer, Integer, Unit> function27 = function25;
                                if (function27 == null) {
                                    $composer5.startReplaceGroup(-647993954);
                                } else {
                                    $composer5.startReplaceGroup(1918759619);
                                    ComposerKt.sourceInformation($composer5, "84@4101L8");
                                    function27.invoke($composer5, 0);
                                }
                                $composer5.endReplaceGroup();
                                function26.invoke($composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), $composer4, 438);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), modifier3, title2, text2, shape3, backgroundColor3, contentColor3, properties2, $composer2, ($dirty2 & 14) | 48 | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & 57344) | (($dirty2 >> 3) & 458752) | (($dirty2 >> 3) & 3670016) | (($dirty2 >> 3) & 29360128) | (234881024 & ($dirty2 >> 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dismissButton2 = dismissButton;
            modifier4 = modifier3;
            title3 = title2;
            text3 = text2;
            shape4 = shape3;
            backgroundColor4 = backgroundColor3;
            contentColor4 = contentColor3;
            properties3 = properties2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

                public final void invoke(Composer composer, int i11) {
                    AndroidAlertDialog_androidKt.m1414AlertDialog6oU6zVQ(function0, function2, modifier4, dismissButton2, title3, text3, shape4, backgroundColor4, contentColor4, properties3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m1415AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        Function2 title;
        Function2 text;
        Shape shape2;
        long backgroundColor2;
        int $dirty;
        int i2;
        int $dirty2;
        long contentColor2;
        DialogProperties properties2;
        int $dirty3;
        Composer $composer2;
        final Modifier modifier3;
        final Function2 text2;
        final Shape shape3;
        final long contentColor3;
        final DialogProperties properties3;
        final Function2 title2;
        final long backgroundColor3;
        int $dirty4;
        Composer $composer3 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,139@6420L275,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function24 = function2;
        } else if (($changed & 48) == 0) {
            function24 = function2;
            $dirty5 |= $composer3.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty5 |= 3072;
            title = function22;
        } else if (($changed & 3072) == 0) {
            title = function22;
            $dirty5 |= $composer3.changedInstance(title) ? 2048 : 1024;
        } else {
            title = function22;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty5 |= 24576;
            text = function23;
        } else if (($changed & 24576) == 0) {
            text = function23;
            $dirty5 |= $composer3.changedInstance(text) ? 16384 : 8192;
        } else {
            text = function23;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i6 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty5 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty5 |= i6;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                int i7 = $composer3.changed(backgroundColor2) ? 1048576 : 524288;
                $dirty5 |= i7;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty5 |= i7;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                $dirty4 = $dirty5;
                int i8 = $composer3.changed(contentColor) ? 8388608 : 4194304;
                $dirty = $dirty4 | i8;
            } else {
                $dirty4 = $dirty5;
            }
            $dirty = $dirty4 | i8;
        } else {
            $dirty = $dirty5;
        }
        int $dirty6 = $dirty;
        int $dirty7 = i & 256;
        if ($dirty7 != 0) {
            $dirty2 = $dirty6 | 100663296;
            i2 = $dirty7;
        } else if (($changed & 100663296) == 0) {
            i2 = $dirty7;
            $dirty2 = $dirty6 | ($composer3.changed(properties) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432);
        } else {
            i2 = $dirty7;
            $dirty2 = $dirty6;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            text2 = text;
            shape3 = shape2;
            contentColor3 = contentColor;
            properties3 = properties;
            title2 = title;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    title = null;
                }
                if (i5 != 0) {
                    text = null;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                }
                if ((i & 64) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    contentColor2 = contentColor;
                }
                if (i2 != 0) {
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    $dirty3 = $dirty2;
                } else {
                    properties2 = properties;
                    $dirty3 = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = contentColor;
                    $dirty3 = $dirty2 & (-29360129);
                    properties2 = properties;
                } else {
                    contentColor2 = contentColor;
                    properties2 = properties;
                    $dirty3 = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            final Modifier modifier4 = modifier2;
            final Function2 title3 = title;
            final Function2 text3 = text;
            final Shape shape4 = shape2;
            final long backgroundColor4 = backgroundColor2;
            final long contentColor4 = contentColor2;
            AndroidDialog_androidKt.Dialog(function0, properties2, ComposableLambdaKt.rememberComposableLambda(-1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer4, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                        }
                        AlertDialogKt.m1412AlertDialogContentWMdw5o4(function25, modifier4, title3, text3, shape4, backgroundColor4, contentColor4, $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & 112), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            text2 = text;
            shape3 = shape2;
            contentColor3 = contentColor2;
            properties3 = properties2;
            title2 = title;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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
                    AndroidAlertDialog_androidKt.m1415AlertDialogwqdebIU(function0, function2, modifier3, title2, text2, shape3, backgroundColor3, contentColor3, properties3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
